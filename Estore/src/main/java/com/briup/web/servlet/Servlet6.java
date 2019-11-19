package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SOrder;
import com.briup.common.bean.SUser;
import com.briup.service.impl.OrderServiceimpl;
@WebServlet("/servlet6")
public class Servlet6 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SUser attribute = (SUser) req.getSession().getAttribute("user");
		long sum = Long.parseLong(req.getParameter("sum"));
		SOrder order=new SOrder();
		order.setDob(new Date());
		order.setOrderid("1");
		order.setSum(sum);
		
		new OrderServiceimpl().insertOrderLine(order);
	}
}
