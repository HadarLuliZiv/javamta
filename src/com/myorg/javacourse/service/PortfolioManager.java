package com.myorg.javacourse.service;

import java.util.Calendar;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

public class PortfolioManager {

	public Portfolio getPortfolio(){
		Portfolio portfolio=new Portfolio("Hadar and Ziv's Portfolio");
		Stock stock1=new Stock("PIH",(float) 13.1,(float) 12.4);
		Calendar c1=Calendar.getInstance();
		c1.set(2014,10,15);
		stock1.setDate(c1.getTime());
		portfolio.addStock(stock1);
		
		Stock stock2=new Stock("AAL",(float) 5.78,(float) 5.5);
		stock2.setDate(c1.getTime());
		portfolio.addStock(stock2);
		
		Stock stock3=new Stock("CAAS",(float) 32.2,(float) 31.5);
		stock3.setDate(c1.getTime());
		portfolio.addStock(stock3);
		
		return portfolio;
		
	}
}
