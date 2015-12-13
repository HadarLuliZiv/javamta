package com.myorg.javacourse.service;

import java.util.Calendar;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

public class PortfolioManager {

	public Portfolio getPortfolio(){
		
		Calendar c1=Calendar.getInstance();
		c1.set(2014,11,15);
		
		Portfolio myPortfolio=new Portfolio("Exercise 7 portfolio");
		myPortfolio.updateBalance(10000);
		Stock stock4=new Stock("PIH",(float) 10.0,(float) 8.5);
		stock4.setDate(c1.getTime());
		Stock stock5=new Stock("AAL",(float) 30.0,(float) 25.5);
		stock5.setDate(c1.getTime());
		Stock stock6=new Stock("CAAS",(float) 20.0,(float) 15.5);
		stock6.setDate(c1.getTime());
		
		myPortfolio.addStock(stock4);
		myPortfolio.addStock(stock5);
		myPortfolio.addStock(stock6);


		myPortfolio.buyStock(stock4, 20);
		myPortfolio.buyStock(stock5, 30);
		myPortfolio.buyStock(stock6, 40);
		
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");

		
		return myPortfolio;
		
	}
}
