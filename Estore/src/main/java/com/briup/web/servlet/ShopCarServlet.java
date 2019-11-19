package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SShopcartItem;
import com.briup.common.bean.SUser;
import com.briup.service.impl.ShopCarImpl;
@WebServlet("/insertServlet")
public class ShopCarServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SUser user=(SUser) req.getSession().getAttribute("user");
		Long userId=user.getId();
		System.out.println(userId);

		long bookId=Long.parseLong(req.getParameter("bookid"));
		System.out.println(bookId);
		
		Long num=Long.parseLong(req.getParameter("count"));
		System.out.println(num);
		SShopcartItem shopcar=new SShopcartItem();
		shopcar.setProductId(bookId);
		shopcar.setNum(num);
		shopcar.setUserId(userId);
		
		System.out.println(shopcar);
		ShopCarImpl sc=new ShopCarImpl();
		sc.insertShopCar(shopcar);
		
		req.getSession().setAttribute("shopcar", shopcar);
		req.getRequestDispatcher("indexSuccess.jsp").forward(req, resp);
	}
}
