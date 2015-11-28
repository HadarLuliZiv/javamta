package com.myorg.javacourse.model;

import com.myorg.javacourse.Stock;

public class Portfolio {
	
	private final static int MAX_PORTFOLIO_SIZE=5;
	private String title;
	private int portfolioSize;
	private Stock[] stocks;
	
	public Portfolio(){
		this.stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addStock(Stock stock){
		this.stocks[portfolioSize]=stock;
		portfolioSize++;
	}
	
	public Stock[] getStocks(){
		return this.stocks;
	}
	
	public String getHtmlString(){
		String result="<h1>"+this.title+"</h1>";
		for(int i=0; i<this.portfolioSize; i++){
			result= result+"<br>"+this.stocks[i].getHtmlDescription();
		}
		return result;
	}
}
