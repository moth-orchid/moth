package com.example.demo.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Article;
import com.example.demo.bean.extend.ArticleExtend;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.Message;
import com.example.demo.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Validated
@ControllerAdvice
@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@ApiOperation(value="查询所有文章" ,notes ="级联查询栏目")
	@GetMapping("/findAllArticle")
	public Message findAll() {
		List<ArticleExtend> findAll = articleService.findAll();
		return MessageUtil.success(findAll);
	}
	
	@ApiOperation(value="查询文章" ,notes ="根据文章的编号")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "id",value = "文章编号" ,paramType = "query")
	) 
	@GetMapping("/findAllArticleById")
	public Message findAllArticleById(Long id) {
		Article data = articleService.findArticleById(id);
		return MessageUtil.success(data);
	}
	
	@ApiOperation(value="删除文章",notes="根据文章的编号")
	@GetMapping("/deleteArticle")
	public Message deleteArticle(Long id) {
		articleService.deleteArticle(id);
		return MessageUtil.success("操作成功");
	}
	@ApiOperation(value="保存或者更新文章",notes="如果参数中包括id，则为更新操作，如果参数中没有id，则为保存操作")
	
	  @ApiImplicitParams({
	  
	  @ApiImplicitParam( name = "id",value = "文章编号",paramType = "query"),
	  
	  @ApiImplicitParam(name = "title",value = "文章标题",paramType = "query"),
	  
	  @ApiImplicitParam(name = "content",value = "文章内容",paramType = "query"),
	  
	  @ApiImplicitParam(name = "categoryId",value = "文章所属栏目",paramType = "query") 
	  })
	 
	@PostMapping("/saveOrUpdate")
	public Message saveOrUpdate(Long id,String title,String content,long categoryId) {
		Article article=new Article();
		article.setId(id);
		article.setContent(content);
		article.setTitle(title);
		article.setCategoryId(categoryId);
		System.out.println(article.getContent());
		articleService.saveOrUpdate(article);
		return MessageUtil.success("更新成功");
	}
}
