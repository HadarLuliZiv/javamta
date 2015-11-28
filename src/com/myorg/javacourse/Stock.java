package com.myorg.javacourse;
import java.util.Date;

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
	
	public String getHtmlDescription(){
		String result = "<b>Stock symbol:<b> "+ getSymbol() +" <b>Stock ask:<b> "+ 
	getAsk()+" <b>Stock bid:<b> "+ getBid()+" <b>Stock date:<b> "+ this.date.getDate()+"/"+(this.date.getMonth()+1)+"/"+(1900+this.date.getYear());
		return result;
	}
}
