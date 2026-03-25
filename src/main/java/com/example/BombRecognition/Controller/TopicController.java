package com.example.BombRecognition.Controller;


import com.example.BombRecognition.Dto.TopicRequestDTO;
import com.example.BombRecognition.Dto.TopicResponseDTO;
import com.example.BombRecognition.Entity.Topic;
import com.example.BombRecognition.Service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/topics")
@Tag(name = "Topic API", description = "Manage incident topics")
public class TopicController {


    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    @PostMapping
    @Operation(summary = "Add new topics")
    public ResponseEntity<List<TopicResponseDTO>> addTopics(
            @RequestBody List<TopicRequestDTO> topics
    ) {
        List<TopicResponseDTO> response = topicService.saveTopics(topics);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all topics")
    public ResponseEntity<List<TopicResponseDTO>> getTopics() {
        List<TopicResponseDTO> response = topicService.getAllTopics();
        return ResponseEntity.ok(response);
    }
}