package com.myorg.javacourse.model;
import java.util.Date;

/**
 * The Stock class holds information about a stock that is 
 * part of a portfolio (e.g: symbol, ask, bid).
 * @author Lenovo
 *
 */
public class Stock {

	private final static int BUY = 0;
	private final static int SELL = 1;
	private final static int REMOVE = 2;
	private final static int HOLD = 3;
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private int recommendation;
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
	getAsk()+", <b>bid</b>: "+ getBid()+" , <b>Stock date:</b> "+ this.date.getDate()+"/"+(this.date.getMonth()+1)+"/"+(1900+this.date.getYear());
		return result;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
