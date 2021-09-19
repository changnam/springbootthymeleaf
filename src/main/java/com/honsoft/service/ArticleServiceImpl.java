package com.honsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.honsoft.entity.Article;

import com.honsoft.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Page<Article> getPaginatedArticles(Pageable pageable) {
		return articleRepository.findAll(pageable);
	}
}