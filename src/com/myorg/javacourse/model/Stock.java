package com.myorg.javacourse.model;
import java.util.Date;

import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

/**
 * The Stock class holds information about a stock that is 
 * part of a portfolio (e.g: symbol, ask, bid).
 * @author Lenovo
 *
 */
public class Stock {

	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	


	public Stock(String symbol, float ask, float bid){
		this.symbol=symbol;
		this.ask=ask;
		this.bid=bid;
	}
	
	public Stock(Stock stock){
		this(stock.getSymbol(),stock.getAsk(),stock.getBid());
		this.date=new Date(stock.getDate().getTime());
		this.recommendation=stock.recommendation;
		this.stockQuantity=stock.stockQuantity;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}

	public float getBid() {
		return bid;
	}

	public void setBid(float bid) {
		this.bid = bid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * The getHtmlDescription method returns a string that holds the stock's 
	 * details. 
	 * @return
	 */
	public String getHtmlDescription(){
		String result = "<b>Stock symbol:</b> "+ getSymbol() +", <b>ask:</b> "+ 
	getAsk()+", <b>bid</b>: "+ getBid()+" , <b>Stock date:</b> "+ this.date.getDate()+"/"+
				(this.date.getMonth()+1)+"/"+(1900+this.date.getYear())+", <b>quantity:</b> "+getStockQuantity();
		return result;
	}

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
