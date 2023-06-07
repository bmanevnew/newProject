package com.example.newproject.mappers;

import com.example.newproject.models.Job;
import com.example.newproject.models.JobDtoIn;
import com.example.newproject.models.JobDtoOut;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class JobMapper {

    public final ModelMapper modelMapper;
    public JobMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public JobDtoOut jobToDto(Job job) {
        JobDtoOut dto = new JobDtoOut();
        dto.setName(modelMapper.map(job.getName(), String.class));
        dto.setDescription(modelMapper.map(job.getDescription(), String.class));
        dto.setId(modelMapper.map(job.getId(), Long.class));
        dto.setActive(modelMapper.map(job.isActive(), Boolean.class));
        return dto;
    }

    public Job dtoToJob(JobDtoIn jobDtoIn){
        Job job = new Job();
        job.setName(jobDtoIn.getName());
        job.setDescription(jobDtoIn.getDescription());
        job.setActive(true);
           return  job;
    }
}
