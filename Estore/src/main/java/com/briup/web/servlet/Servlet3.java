package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SProduct;
import com.briup.common.bean.SShopcartItem;
import com.briup.service.impl.IBookServiceImpl;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IBookServiceImpl bs=new IBookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<SProduct,Long> map2=new HashMap<>();
		List<SShopcartItem> shopcar = (List<SShopcartItem>) req.getSession().getAttribute("list1");
		for(SShopcartItem st:shopcar) {
			System.out.println("**********>>>>>>>>>>");
			System.out.println(st);
			Long productId = st.getProductId();
			SProduct product = bs.findBookById(productId);
			System.out.println(product);
			long num=st.getNum();
			map2.put(product,num );
			req.getSession().setAttribute("map2", map2);
		}
		System.out.println(map2);
		req.getRequestDispatcher("ShopCart.jsp").forward(req, resp);
	}
}
