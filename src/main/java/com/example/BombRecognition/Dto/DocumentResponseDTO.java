package com.example.BombRecognition.Dto;


import java.time.LocalDateTime;
import java.util.List;

public class DocumentResponseDTO {

    private Long id;
    private String originalText;
    private LocalDateTime createdAt;
    private List<ClassifiedTextResponseDTO> classifiedTexts;

    public DocumentResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ClassifiedTextResponseDTO> getClassifiedTexts() {
        return classifiedTexts;
    }

    public void setClassifiedTexts(List<ClassifiedTextResponseDTO> classifiedTexts) {
        this.classifiedTexts = classifiedTexts;
    }
}