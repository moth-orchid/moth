package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Article;
import com.example.demo.bean.extend.ArticleExtend;
import com.example.demo.utils.Message;

public interface ArticleService {

	List<ArticleExtend> findAll();

	void deleteArticle(Long id);

	void saveOrUpdate(Article article);

	Article findArticleById(Long id);
	
}
