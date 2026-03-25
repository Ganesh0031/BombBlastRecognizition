package com.example.BombRecognition.Repository;

import com.example.BombRecognition.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.function.LongFunction;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
