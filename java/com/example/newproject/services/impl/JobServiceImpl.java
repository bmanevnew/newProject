package com.example.newproject.services.impl;

import com.example.newproject.exceptions.EntityDuplicationException;
import com.example.newproject.exceptions.EntityNotFoundException;
import com.example.newproject.exceptions.InvalidParamException;
import com.example.newproject.models.Job;
import com.example.newproject.repositories.JobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.newproject.services.impl.NewsServiceImpl.PAGE_IS_INVALID;


@Service
public class JobServiceImpl implements JobService {

    public static final String JOB_ALREADY_POSTED = "This job is already posted";
    public static final String ID_MUST_BE_POSITIVE = "Id must be positive.";
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job create(Job job) {
        if (jobExists(job)) {
            throw new EntityDuplicationException(String.format(JOB_ALREADY_POSTED, job.getName(), job.getDescription()));
        }
        return jobRepository.save(job);
    }

    private boolean jobExists(Job job) {
        if (jobRepository.findFirstByNameAndDescription(job.getName(), job.getDescription()).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public Job update(Job job) {
        Job persistentJob = getById(job.getId());
        persistentJob.setName(job.getName());
        persistentJob.setDescription(job.getDescription());

        return jobRepository.save(persistentJob);
    }

    @Override
    public Job delete(long id) {
        validateId(id);
        Job jobToBeDeleted = jobRepository.findById(id).orElseThrow(()->new  EntityNotFoundException("Job", id));
        jobRepository.delete(jobToBeDeleted);
        return jobToBeDeleted;
    }
    public Job getById(long id) {
        validateId(id);
        return jobRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Job", id));
    }
    private void validateId(Long id) {
        if (id != null && id <= 0) {
            throw new InvalidParamException(ID_MUST_BE_POSITIVE);
        }
    }

    public List<Job> getAll(Pageable pageable) {
        Page<Job> page = jobRepository.getAll(pageable);
        if (pageable.getPageNumber() >= page.getTotalPages() && pageable.getPageNumber() != 0) {
            throw new InvalidParamException(PAGE_IS_INVALID);
        }
        return page.getContent();
    }
}
