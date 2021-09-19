package com.honsoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.honsoft.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findAll(Pageable pageable);
    
}