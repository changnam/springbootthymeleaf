package com.honsoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.honsoft.entity.Article;

public interface ArticleService {
	Page<Article> getPaginatedArticles(Pageable pageable);
}
