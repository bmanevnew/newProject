package com.example.newproject.services.impl;

import com.example.newproject.models.News;

public interface NewService {
    News create(News post);

    News update(News post);

    News delete(long id);

}
