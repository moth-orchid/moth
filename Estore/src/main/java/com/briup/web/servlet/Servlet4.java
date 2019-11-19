package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.common.bean.SProduct;
import com.briup.service.impl.OrderServiceimpl;

@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sumprice=0;
		List<SProduct> list3=new ArrayList<>();	
		String[] parameterValues = req.getParameterValues("check[]");
			System.out.println(Arrays.toString(parameterValues));
			if(parameterValues!=null) {
			for(int i=0;i<parameterValues.length;i++) {
				if(parameterValues[i]!=null) {
					//总价
					Long sum=Long.parseLong(req.getParameterValues("sum")[i]);
					if(sum!=0) {
						sumprice+=sum;
					}
					String img=req.getParameterValues("img")[i];
					String name=req.getParameterValues("name")[i];
					Long price=Long.parseLong(req.getParameterValues("price")[i]);
					Long count=Long.parseLong(req.getParameterValues("count")[i]);
					
					SProduct sp=new SProduct();
					sp.setImg(img);
				    sp.setName(name);
				    sp.setPrice(price);
				    sp.setSellnum(count);
				    System.out.println(sp);
				    
				    list3.add(sp);
				}
			}
			}
		req.setAttribute("sumprice", sumprice);
		req.getSession().setAttribute("list3", list3);
	    
	    req.getRequestDispatcher("confirm.jsp").forward(req, resp);
	}
}
