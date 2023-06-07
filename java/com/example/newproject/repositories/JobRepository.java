package com.example.newproject.repositories;

import com.example.newproject.models.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j.name, j.description " +
            "FROM Job j " +
            "WHERE j.name IS NOT NULL AND j.description IS NOT NULL")
    Page<Job> getAll(Pageable pageable);
    Optional findFirstByNameAndDescription(String name, String description);

}
