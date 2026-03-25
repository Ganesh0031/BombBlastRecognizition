package com.example.BombRecognition.Entity;

import jakarta.persistence.*;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import java.util.List;
@Entity
public class Topic{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "topic_keywords", joinColumns = @JoinColumn(name = "topic_id"))
    @Column(name = "keyword")
    private List<String> keywords;

    public Topic(Long id, String title, List<String> keywords) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
    }

    public Topic() {
    }

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
