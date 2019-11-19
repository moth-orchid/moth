package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SCate;
import com.briup.common.bean.SCateDetail;
import com.briup.common.bean.SProduct;
import com.briup.common.bean.SReport;
import com.briup.common.bean.SUser;
import com.briup.service.impl.CateServiceImpl;
import com.briup.service.impl.IBookServiceImpl;
import com.briup.service.impl.LoginService;
import com.briup.service.impl.ReportServiceImpl;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LoginService loginservice=new LoginService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		SUser user = loginservice.findAllSUer(username, password);
		System.out.println(user);
		
		if(user!=null) {
			req.getSession().setAttribute("user", user);
			
			Cookie cookie=new Cookie("user",username+"@"+password);
			cookie.setMaxAge(60*60*24);
			resp.addCookie(cookie);
			
			
			  CateServiceImpl cs=new CateServiceImpl();
			  Map<SCate, List<SCateDetail>> map =cs.getCateDetailsInfo(); 
			  req.getSession().setAttribute("map", map);
			  
			  System.out.println(map);
			  ReportServiceImpl rs=new ReportServiceImpl(); 
			  List<SReport> report =rs.findAllReport(); 
			  req.getSession().setAttribute("report", report);
			 
			  IBookServiceImpl bs=new IBookServiceImpl();
			  List<SProduct> book = bs.findAllBook();
			  req.getSession().setAttribute("book", book);
			
			  req.getRequestDispatcher("indexSuccess.jsp").forward(req, resp);
		}
		
	}
}
