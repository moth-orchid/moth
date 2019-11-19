package com.example.demo.bean.extend;

import java.util.List;

import com.example.demo.bean.Article;
import com.example.demo.bean.Category;
import com.example.demo.bean.Comment;

public class ArticleExtend extends Article{
	public static final String  STATUS_UNCHECK="未审核";
	public static final String  STATUS_CHECK_PASS="审核通过";
	public static final String  STATUS_CHECK_NOPASS="审核未通过";
	public Category category;
	private List<Comment> comment;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
}
