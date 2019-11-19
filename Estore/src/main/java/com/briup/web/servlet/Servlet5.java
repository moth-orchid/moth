package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.Orderline;
import com.briup.common.bean.SProduct;
import com.briup.common.bean.SShopcartItem;
import com.briup.common.bean.SUser;
import com.briup.service.impl.IBookServiceImpl;
import com.briup.service.impl.ShopCarImpl;
@WebServlet("/servlet5")
public class Servlet5 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String flag=req.getParameter("num");
		Long count=Long.parseLong(req.getParameter("count"));
		
		long id = new IBookServiceImpl().findBookByName(name);
		SUser user=(SUser) req.getSession().getAttribute("user");
		long userid=user.getId();
	
		SShopcartItem st=new SShopcartItem();
		Long id2 = new ShopCarImpl().selectShopCarByProductid2(id);
		st.setId(id2);
		st.setUserId(userid);
		st.setProductId(id);
		 if(flag.equals("加")) {
			 st.setNum(1l);
			 new ShopCarImpl().updateshopcar(st);
		 }else {
			 st.setNum(-1l);
			 new ShopCarImpl().updateshopcar(st);
		 }
		 resp.sendRedirect("Servlet2");
	}
}
