package com.example.BombRecognition.Repository;

import com.example.BombRecognition.Entity.ClassifiedText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassifiedTextRepository extends JpaRepository<ClassifiedText,Long> {
    List<ClassifiedText> findByDocumentId(Long documentId);
}
