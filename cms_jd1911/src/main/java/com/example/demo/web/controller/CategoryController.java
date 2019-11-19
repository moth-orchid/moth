package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Category;
import com.example.demo.bean.extend.ArticleExtend;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.Message;
import com.example.demo.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Validated
@ControllerAdvice
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@ApiOperation(value="查询所有栏目")
	@GetMapping("/findAllCategory")
	public Message findAllCategory() {
		List<Category> list=categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@ApiOperation(value="保存或者更新栏目")
	@RequestMapping("/saveOrUpdate")
	public Message saveOrUpdate(Category category) {
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("执行成功");
	}
	
	@RequestMapping("/deleteById")
	@ApiOperation(value="根据编号删除栏目")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "id",value = "根据编号",paramType = "query",required = true)
	)
	public Message deleteById(Long id) {
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
	
	@RequestMapping("/batchDelete")	  
	  @ApiOperation(value="根据编号删除栏目")	 
	  @ApiImplicitParams(
				@ApiImplicitParam(name = "ids",value = "根据编号",paramType = "query",required = true)
			  )
	  public Message batchDelete(Long[] ids) { 
		System.out.println(ids);
		  categoryService.batchDelete(ids);
		  return MessageUtil.success("删除成功"); 
	
	  }
	 
}
