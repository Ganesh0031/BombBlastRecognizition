package com.example.BombRecognition.Dto;


public class ClassifiedTextRequestDTO {

    private String textChunk;
    private Double confidenceScore;
    private Long topicId;

    public ClassifiedTextRequestDTO() {}

    public String getTextChunk() {
        return textChunk;
    }

    public void setTextChunk(String textChunk) {
        this.textChunk = textChunk;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}