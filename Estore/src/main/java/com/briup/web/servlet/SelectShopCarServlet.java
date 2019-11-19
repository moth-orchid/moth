package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SShopcartItem;
import com.briup.common.bean.SUser;
import com.briup.service.impl.ShopCarImpl;

@WebServlet("/selectServlet")
public class SelectShopCarServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShopCarImpl sc=new ShopCarImpl();
		SUser user = (SUser) req.getSession().getAttribute("user");
		long id=user.getId();
		List<SShopcartItem> selectAllSShopcartItem = sc.selectAllSShopcartItem(id);
		
		req.getSession().setAttribute("shopcarmessage", selectAllSShopcartItem);
	}
}
