package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SProduct;
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String parameter = req.getParameter("price");
				System.out.println(parameter);
				System.out.println("************");
				Long price=Long.parseLong(parameter);
				Long id=Long.parseLong(req.getParameter("id"));
				String img=req.getParameter("img");
				String name=req.getParameter("name");
				SProduct product=new SProduct();
				product.setName(name);
				product.setImg(img);
				product.setPrice(price);
				product.setId(id);
				
				req.getSession().setAttribute("product", product);
				req.getRequestDispatcher("viewBook.jsp").forward(req, resp);
	}
}
