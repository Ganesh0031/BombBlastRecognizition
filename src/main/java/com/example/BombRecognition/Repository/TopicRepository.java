package com.example.BombRecognition.Repository;

import com.example.BombRecognition.Entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByTitle(String title);
}