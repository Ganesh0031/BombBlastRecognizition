package com.example.BombRecognition.Service;

import com.example.BombRecognition.Dto.TopicRequestDTO;
import com.example.BombRecognition.Dto.TopicResponseDTO;
import com.example.BombRecognition.Entity.Topic;
import com.example.BombRecognition.Repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TopicService {

    List<TopicResponseDTO> saveTopics(List<TopicRequestDTO> topics);

    List<TopicResponseDTO> getAllTopics();
}
