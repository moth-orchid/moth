package com.example.demo.dao.extend;

import java.util.List;

import com.example.demo.bean.Comment;

public interface CommentExtendMapper {
	List<Comment> findAllCommentByid(Long id);
}
