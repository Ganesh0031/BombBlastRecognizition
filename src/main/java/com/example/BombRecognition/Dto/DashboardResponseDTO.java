package com.example.BombRecognition.Dto;


import java.util.Map;

public class DashboardResponseDTO {

    private long totalDocuments;
    private long totalChunks;
    private Map<String, Integer> topicDistribution;

    public DashboardResponseDTO() {}

    public long getTotalDocuments() {
        return totalDocuments;
    }

    public void setTotalDocuments(long totalDocuments) {
        this.totalDocuments = totalDocuments;
    }

    public long getTotalChunks() {
        return totalChunks;
    }

    public void setTotalChunks(long totalChunks) {
        this.totalChunks = totalChunks;
    }

    public Map<String, Integer> getTopicDistribution() {
        return topicDistribution;
    }

    public void setTopicDistribution(Map<String, Integer> topicDistribution) {
        this.topicDistribution = topicDistribution;
    }
}