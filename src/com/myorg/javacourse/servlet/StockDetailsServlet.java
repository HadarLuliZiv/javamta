package com.myorg.javacourse.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.*;

import com.myorg.javacourse.model.Stock;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		Stock stock1=new Stock("PIH",(float) 13.1,(float) 12.4);
		Calendar c1=Calendar.getInstance();
		c1.set(2014,10,15);
		stock1.setDate(c1.getTime());
		

		
		Stock stock2=new Stock("AAL",(float) 5.78,(float) 5.5);
		stock2.setDate(c1.getTime());
		
		Stock stock3=new Stock("CAAS",(float) 32.2,(float) 31.5);
		stock3.setDate(c1.getTime());
		
		resp.getWriter().println(stock1.getHtmlDescription()+"<br>"+stock2.getHtmlDescription()+"<br>"
				+ stock3.getHtmlDescription());
	}
}
