package com.example.newproject.mappers;

import com.example.newproject.models.News;
import com.example.newproject.models.NewsDtoOut;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NewsMapper {


    public final ModelMapper modelMapper;

    public NewsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NewsDtoOut newsToDto(News post) {
        NewsDtoOut dto = new NewsDtoOut();
        dto.setName(modelMapper.map(post.getName(), String.class));
        dto.setSmallName(modelMapper.map(post.getSmallName(), String.class));
        dto.setDescription(modelMapper.map(post.getDescription(), String.class));
        if (post.getPhotos()!=(null)) {
            dto.setPhotos(modelMapper.map(post.getPhotos(), String.class));
        }else {
            dto.setPhotos("no photos");
        }
        dto.setId(modelMapper.map(post.getId(), Long.class));
        dto.setDate(modelMapper.map(post.getDate().toLocalDate(), LocalDate.class));
        return dto;
    }

}
