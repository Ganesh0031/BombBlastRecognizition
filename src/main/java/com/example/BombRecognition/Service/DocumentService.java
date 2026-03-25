package com.example.BombRecognition.Service;

import com.example.BombRecognition.Dto.DocumentResponseDTO;
import com.example.BombRecognition.Entity.ClassifiedText;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DocumentService {

    DocumentResponseDTO processDocument(MultipartFile file, String rawText);

    DocumentResponseDTO getResults(Long documentId);
}