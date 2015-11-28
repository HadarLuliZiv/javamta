package com.myorg.javacourse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		Stock stock1=new Stock();
		stock1.setSymbol("PIH");
		stock1.setAsk((float) 13.1);
		stock1.setBid((float) 12.4);
		Calendar c1=Calendar.getInstance();
		c1.set(2014,10,15);
		stock1.setDate(c1.getTime());
		

		
		Stock stock2=new Stock();
		stock2.setSymbol("AAL");
		stock2.setAsk((float) 5.78);
		stock2.setBid((float) 5.5);
		stock2.setDate(c1.getTime());
		
		Stock stock3=new Stock();
		stock3.setSymbol("CAAS");
		stock3.setAsk((float) 32.2);
		stock3.setBid((float) 31.5);
		stock3.setDate(c1.getTime());
		
		resp.getWriter().println(stock1.getHtmlDescription()+"<br>"+stock2.getHtmlDescription()+"<br>"
				+ stock3.getHtmlDescription());
	}
}
