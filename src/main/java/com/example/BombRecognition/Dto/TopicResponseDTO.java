package com.example.BombRecognition.Dto;


import java.util.List;

public class TopicResponseDTO {

    private Long id;
    private String title;
    private List<String> keywords;

    public TopicResponseDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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