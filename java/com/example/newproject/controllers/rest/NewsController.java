package com.example.newproject.controllers.rest;

import com.example.newproject.mappers.NewsMapper;
import com.example.newproject.models.News;
import com.example.newproject.models.NewsDtoOut;
import com.example.newproject.services.impl.NewsServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/news")
public class NewsController {
private  final NewsServiceImpl newsService;
private final NewsMapper newsMapper;

    public NewsController(NewsServiceImpl newsService, NewsMapper newsMapper) {
        this.newsService = newsService;
        this.newsMapper = newsMapper;
    }

    @GetMapping
    public List<NewsDtoOut> getAll(Pageable pageable) {
        List<News> newsList = newsService.getAll(pageable);
        return newsList.stream()
                .map(newsMapper::newsToDto)
                .collect(Collectors.toList());
    }
    public News getById(long id ) {

        return newsService.getById(id);
    }

    @GetMapping(value ="/{id}", produces = "application/json")
    public NewsDtoOut getByIdDto(@PathVariable long id) {
        return newsMapper.newsToDto(getById(id));
    }

}
