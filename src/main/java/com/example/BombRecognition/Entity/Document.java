package com.example.BombRecognition.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String originalText;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClassifiedText> classifiedTexts;

    public Document() {
    }

    public Document(Long id, String originalText, LocalDateTime createdAt, List<ClassifiedText> classifiedTexts) {
        this.id = id;
        this.originalText = originalText;
        this.createdAt = createdAt;
        this.classifiedTexts = classifiedTexts;
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

    public List<ClassifiedText> getClassifiedTexts() {
        return classifiedTexts;
    }

    public void setClassifiedTexts(List<ClassifiedText> classifiedTexts) {
        this.classifiedTexts = classifiedTexts;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
