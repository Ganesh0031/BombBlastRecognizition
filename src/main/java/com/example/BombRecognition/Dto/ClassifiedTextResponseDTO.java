package com.example.BombRecognition.Dto;

public class ClassifiedTextResponseDTO {

    private Long id;
    private String textChunk;
    private Double confidenceScore;
    private TopicResponseDTO topic;

    public ClassifiedTextResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public TopicResponseDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicResponseDTO topic) {
        this.topic = topic;
    }
}