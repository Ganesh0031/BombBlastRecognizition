package com.example.BombRecognition.Service.ServiceImpl;

import com.example.BombRecognition.Dto.ClassifiedTextResponseDTO;
import com.example.BombRecognition.Dto.DocumentResponseDTO;
import com.example.BombRecognition.Dto.TopicResponseDTO;
import com.example.BombRecognition.Entity.ClassifiedText;
import com.example.BombRecognition.Entity.Document;
import com.example.BombRecognition.Entity.Topic;
import com.example.BombRecognition.Repository.ClassifiedTextRepository;
import com.example.BombRecognition.Repository.DocumentRepository;
import com.example.BombRecognition.Repository.TopicRepository;
import com.example.BombRecognition.Service.DocumentService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Service
public class DocumentServiceImp implements DocumentService {

    private final DocumentRepository documentRepository;
    private final TopicRepository topicRepository;
    private final ClassifiedTextRepository classifiedTextRepository;
    private final ModelMapper modelMapper;

    public DocumentServiceImp(DocumentRepository documentRepository,
                              TopicRepository topicRepository,
                              ClassifiedTextRepository classifiedTextRepository,
                              ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.topicRepository = topicRepository;
        this.classifiedTextRepository = classifiedTextRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DocumentResponseDTO processDocument(MultipartFile file, String rawText) {

        String text = "";

        try {
            if (file != null && !file.isEmpty()) {
                PDDocument document = PDDocument.load(file.getInputStream());
                PDFTextStripper stripper = new PDFTextStripper();
                text = stripper.getText(document);
                document.close();
            } else {
                text = rawText;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing document");
        }

        Document doc = new Document();
        doc.setOriginalText(text);
        doc = documentRepository.save(doc);


        String[] chunks = text.split("(?<=[.!?])\\s+");

        List<Topic> topics = topicRepository.findAll();
        List<ClassifiedText> results = new ArrayList<>();

        for (String chunk : chunks) {

            Topic bestTopic = null;
            int maxScore = 0;

            for (Topic topic : topics) {
                int score = 0;

                for (String keyword : topic.getKeywords()) {
                    if (chunk.toLowerCase().contains(keyword.toLowerCase())) {
                        score++;
                    }
                }

                if (score > maxScore) {
                    maxScore = score;
                    bestTopic = topic;
                }
            }

            double confidence = (bestTopic != null)
                    ? (double) maxScore / bestTopic.getKeywords().size()
                    : 0.0;

            ClassifiedText ct = new ClassifiedText();
            ct.setTextChunk(chunk);
            ct.setConfidenceScore(confidence);
            ct.setDocument(doc);
            ct.setTopic(bestTopic);

            results.add(ct);
        }

        classifiedTextRepository.saveAll(results);

        // Convert to DTO
        return mapToDocumentResponse(doc, results);
    }

    @Override
    public DocumentResponseDTO getResults(Long documentId) {

        Document doc = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        List<ClassifiedText> results =
                classifiedTextRepository.findByDocumentId(documentId);

        return mapToDocumentResponse(doc, results);
    }

    private DocumentResponseDTO mapToDocumentResponse(Document doc, List<ClassifiedText> results) {

        DocumentResponseDTO dto = new DocumentResponseDTO();
        dto.setId(doc.getId());
        dto.setOriginalText(doc.getOriginalText());
        dto.setCreatedAt(doc.getCreatedAt());

        List<ClassifiedTextResponseDTO> ctDtos = new ArrayList<>();

        for (ClassifiedText ct : results) {

            ClassifiedTextResponseDTO ctDto = new ClassifiedTextResponseDTO();
            ctDto.setId(ct.getId());
            ctDto.setTextChunk(ct.getTextChunk());
            ctDto.setConfidenceScore(ct.getConfidenceScore());

            if (ct.getTopic() != null) {
                TopicResponseDTO topicDto = modelMapper.map(ct.getTopic(), TopicResponseDTO.class);
                ctDto.setTopic(topicDto);
            }

            ctDtos.add(ctDto);
        }

        dto.setClassifiedTexts(ctDtos);

        return dto;
    }
}