package com.example.newproject.services.impl;

import com.example.newproject.exceptions.EntityNotFoundException;
import com.example.newproject.exceptions.InvalidParamException;
import com.example.newproject.models.News;
import com.example.newproject.repositories.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsServiceImpl implements NewService {
    public static final String ID_MUST_BE_POSITIVE = "Id must be positive.";
    public static final String PAGE_IS_INVALID = "Page number is invalid.";
    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News create(News post) {
        return newsRepository.save(post);
    }

    @Override
    public News update(News post) {
        News persistentPost = getById(post.getId());
        persistentPost.setName(post.getName());
        persistentPost.setDescription(post.getDescription());
        persistentPost.setPhotos(post.getPhotos());
        persistentPost.setDate(post.getDate());
        return newsRepository.save(persistentPost);
    }

    public List<News> getAll(Pageable pageable) {
        Page<News> page = newsRepository.getAll(pageable);
        if (pageable.getPageNumber() >= page.getTotalPages() && pageable.getPageNumber() != 0) {
            throw new InvalidParamException(PAGE_IS_INVALID);
        }
        return page.getContent();
    }
    @Override
    public News delete(long id) {
        News postToBeDeleted = getById(id);
        newsRepository.delete(postToBeDeleted);
        return postToBeDeleted;
    }
    public News getById(long id) {
        validateId(id);
        return newsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post", id));
    }
    private void validateId(Long id) {
        if (id != null && id <= 0) {
            throw new InvalidParamException(ID_MUST_BE_POSITIVE);
        }
    }
}
