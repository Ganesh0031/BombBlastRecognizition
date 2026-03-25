package com.example.BombRecognition.Service.ServiceImpl;

import com.example.BombRecognition.Dto.DashboardResponseDTO;
import com.example.BombRecognition.Entity.ClassifiedText;
import com.example.BombRecognition.Repository.ClassifiedTextRepository;
import com.example.BombRecognition.Repository.DocumentRepository;
import com.example.BombRecognition.Service.DashboardService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DashboardServiceImp implements DashboardService {

    private final DocumentRepository documentRepository;
    private final ClassifiedTextRepository classifiedTextRepository;
    private final ModelMapper modelMapper;

    public DashboardServiceImp(DocumentRepository documentRepository,
                               ClassifiedTextRepository classifiedTextRepository,
                               ModelMapper modelMapper) {
        this.documentRepository = documentRepository;
        this.classifiedTextRepository = classifiedTextRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DashboardResponseDTO getDashboard() {

        long totalDocuments = documentRepository.count();
        long totalChunks = classifiedTextRepository.count();

        List<ClassifiedText> all = classifiedTextRepository.findAll();

        Map<String, Integer> topicDistribution = new HashMap<>();

        for (ClassifiedText ct : all) {
            String topic = (ct.getTopic() != null)
                    ? ct.getTopic().getTitle()
                    : "UNCLASSIFIED";

            topicDistribution.put(topic,
                    topicDistribution.getOrDefault(topic, 0) + 1);
        }
        DashboardResponseDTO dto = new DashboardResponseDTO();
        dto.setTotalDocuments(totalDocuments);
        dto.setTotalChunks(totalChunks);
        dto.setTopicDistribution(topicDistribution);

        return dto;
    }
}