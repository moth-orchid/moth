package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SUser;
import com.briup.service.impl.RegisterService;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	RegisterService re=new RegisterService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String zip = req.getParameter("zip");
		String address = req.getParameter("address");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		Date dob=new Date();
		System.out.println("**************");
		SUser user=new SUser(name,password,zip,address,telephone,email,dob);
		System.out.println(user);
		
		SUser user1 = re.findAllSUer(user);
		
		req.getSession().setAttribute("user1", user1);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
