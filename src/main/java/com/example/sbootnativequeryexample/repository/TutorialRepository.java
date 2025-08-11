package com.example.sbootnativequeryexample.repository;

import com.example.sbootnativequeryexample.entity.Tutorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

  @Query(value = "SELECT * FROM tutorials", nativeQuery = true)
  List<Tutorial> findAll();

  @Query(value = "SELECT * FROM tutorials t WHERE t.published = ?1", nativeQuery = true)
  List<Tutorial> findByPublished(boolean isPublished);

  @Query(value = "SELECT * FROM tutorials t WHERE t.title LIKE %?1%", nativeQuery = true)
  List<Tutorial> findByTitleLike(String title);

  @Query(value = "SELECT * FROM tutorials t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1, '%'))", nativeQuery = true)
  List<Tutorial> findByTitleLikeCaseInsensitive(String title);
}
