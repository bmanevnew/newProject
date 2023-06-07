package com.example.newproject.controllers.rest;

import com.example.newproject.mappers.JobMapper;
import com.example.newproject.models.Job;
import com.example.newproject.models.JobDtoIn;
import com.example.newproject.models.JobDtoOut;
import com.example.newproject.services.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobs")
public class JobController {


    private final JobMapper jobMapper;

    private final JobServiceImpl jobService;

    @Autowired
    public JobController(JobMapper jobMapper, JobServiceImpl jobService) {
        this.jobMapper = jobMapper;
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobDtoOut> getAll(Pageable pageable) {
        List<Job> newsList = jobService.getAll(pageable);
        return newsList.stream()
                .map(jobMapper::jobToDto)
                .collect(Collectors.toList());
    }

    public Job getById(long id) {

        return jobService.getById(id);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public JobDtoOut getByIdDto(@PathVariable long id) {
        return jobMapper.jobToDto(getById(id));
    }


   // @PreAuthorize("isAuthenticated()")
    @PostMapping
    public JobDtoOut create(@Valid @RequestBody JobDtoIn jobDtoIn) {
        Job job = jobMapper.dtoToJob(jobDtoIn);
        return jobMapper.jobToDto(jobService.create(job));
    }
    @DeleteMapping("/{id}")
    public JobDtoOut delete(@PathVariable long id) {
        return jobMapper.jobToDto(jobService.delete(id));
    }


}
