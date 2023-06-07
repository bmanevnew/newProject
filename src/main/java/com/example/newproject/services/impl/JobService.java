package com.example.newproject.services.impl;

import com.example.newproject.models.Job;

public interface JobService {
    Job create(Job job);

    Job update(Job job);

    Job delete(long id);


}
