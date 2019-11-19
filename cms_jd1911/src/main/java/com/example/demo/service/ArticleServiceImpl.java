package com.example.demo.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Article;
import com.example.demo.bean.ArticleExample;
import com.example.demo.bean.extend.ArticleExtend;
import com.example.demo.dao.ArticleMapper;
import com.example.demo.dao.extend.ArticleExtendMapper;
import com.example.demo.utils.CustomerException;
import com.example.demo.utils.Message;
@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	
	@Resource
	private ArticleMapper articleMapper;
	
	@Override
	public List<ArticleExtend> findAll() {
		
		return articleExtendMapper.selectAll();
	}
	@Override
	public void deleteArticle(Long id) {
		articleMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public void saveOrUpdate(Article article) {
		if(article.getId()!=null) {
			System.out.println(article.getId());
			articleMapper.updateByPrimaryKey(article);
		}else {
			ArticleExample example=new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> selectByExample = articleMapper.selectByExample(example);
			if(selectByExample.size()>0) {
				throw new CustomerException("标题已经存在");
			}
			article.setPublishTime(new Date().getTime());
			articleMapper.insert(article);
		}
	}
	@Override
	public Article findArticleById(Long id) {
		return articleMapper.selectByPrimaryKey(id);
	}

}
