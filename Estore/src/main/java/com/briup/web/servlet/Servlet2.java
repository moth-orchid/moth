package com.briup.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SShopcartItem;
import com.briup.common.bean.SUser;
import com.briup.service.impl.ShopCarImpl;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ShopCarImpl sc=new ShopCarImpl();
		SUser user = (SUser)req.getSession().getAttribute("user");
		List<SShopcartItem> list1 = sc.selectAllSShopcartItem(user.getId());
		
		System.out.println(list1);

		req.getSession().setAttribute("list1", list1);
		
		req.getRequestDispatcher("Servlet3").forward(req, resp);
	}
}
