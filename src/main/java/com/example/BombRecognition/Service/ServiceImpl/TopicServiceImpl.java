package com.example.BombRecognition.Service.ServiceImpl;

import com.example.BombRecognition.Dto.TopicRequestDTO;
import com.example.BombRecognition.Dto.TopicResponseDTO;
import com.example.BombRecognition.Entity.Topic;
import com.example.BombRecognition.Repository.TopicRepository;
import com.example.BombRecognition.Service.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final ModelMapper modelMapper;

    public TopicServiceImpl(TopicRepository topicRepository,
                            ModelMapper modelMapper) {
        this.topicRepository = topicRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TopicResponseDTO> saveTopics(List<TopicRequestDTO> topics) {

        List<Topic> topicEntities = topics.stream()
                .map(dto -> modelMapper.map(dto, Topic.class))
                .collect(Collectors.toList());


        List<Topic> savedTopics = topicRepository.saveAll(topicEntities);


        return savedTopics.stream()
                .map(topic -> modelMapper.map(topic, TopicResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TopicResponseDTO> getAllTopics() {

        List<Topic> topics = topicRepository.findAll();

        return topics.stream()
                .map(topic -> modelMapper.map(topic, TopicResponseDTO.class))
                .collect(Collectors.toList());
    }
}
