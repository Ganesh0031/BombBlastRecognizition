package com.example.BombRecognition.Dto;

import java.util.List;

public class TopicRequestDTO {

    private String title;
    private List<String> keywords;

    public TopicRequestDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}