package com.myorg.javacourse.service;

import java.util.Calendar;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;

public class PortfolioManager {

	public Portfolio getPortfolio(){
		Portfolio portfolio=new Portfolio();
		portfolio.setTitle("Hadar's and Ziv's Portfolio");
		Stock stock1=new Stock();
		stock1.setSymbol("PIH");
		stock1.setAsk((float) 13.1);
		stock1.setBid((float) 12.4);
		Calendar c1=Calendar.getInstance();
		c1.set(2014,10,15);
		stock1.setDate(c1.getTime());
		portfolio.addStock(stock1);
		
		Stock stock2=new Stock();
		stock2.setSymbol("AAL");
		stock2.setAsk((float) 5.78);
		stock2.setBid((float) 5.5);
		stock2.setDate(c1.getTime());
		portfolio.addStock(stock2);
		
		Stock stock3=new Stock();
		stock3.setSymbol("CAAS");
		stock3.setAsk((float) 32.2);
		stock3.setBid((float) 31.5);
		stock3.setDate(c1.getTime());
		portfolio.addStock(stock3);
		
		return portfolio;
		
	}
}
