package com.example.newproject.repositories;

import com.example.newproject.models.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
    @Query("SELECT n FROM News n WHERE n.name IS NOT NULL AND n.smallName IS NOT NULL AND (n.photos IS NOT NULL OR n.photos IS NULL) ORDER BY n.date DESC")
    Page<News> getAll(Pageable pageable);


}
