package com.example.BombRecognition.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperFile {
    @Bean
     public ModelMapper modelMapper(){
         return new ModelMapper();
     }
}
