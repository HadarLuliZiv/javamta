package com.myorg.javacourse.model;

/**
 * The Portfolio class holds information about a portfolio, as well as a
 * stock array.
 * @author Lenovo
 *
 */
public class Portfolio {
	
	private final static int MAX_PORTFOLIO_SIZE=5;
	private String title;
	private int portfolioSize;
	private Stock[] stocks;
	
	public Portfolio(String title){
		this.title=title;
		this.stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public Portfolio(Portfolio portfolio){
		this(portfolio.getTitle());
		this.portfolioSize=portfolio.getPortfolioSize();
		for(int i=0; i<this.getPortfolioSize();i++){
			this.stocks[i]=new Stock(portfolio.stocks[i]);
		}
	}
	
	public int getPortfolioSize() {
		return portfolioSize;
	}
	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * The addstock method is responsible of adding a new stock to the stock's array.
	 * @param stock
	 */
	public void addStock(Stock stock){
		if(portfolioSize<MAX_PORTFOLIO_SIZE){
			this.stocks[portfolioSize]=stock;
			portfolioSize++;
		}
		else
			System.out.println("ERROR, Cannot add stock!");
	}
	
	public void removeStock(Stock stock){
		for(int i=0; i<this.getPortfolioSize(); i++)
		{
			if(this.getStocks()[i]==stock){
				this.getStocks()[i]=this.getStocks()[this.portfolioSize-1];
				this.portfolioSize--;
				break;
			}
			if(i==this.getPortfolioSize()-1){
				System.out.println("This stock is not at this portfolio!");
			}
		}

	}
	
	public Stock[] getStocks(){
		return this.stocks;
	}
	
	/**
	 * The getHtmlString method returns a string with all the details of the stocks 
	 * that is inside the portfolio.
	 * @return
	 */
	public String getHtmlString(){
		String result="<h1>"+this.title+"</h1>";
		for(int i=0; i<this.portfolioSize; i++){
			result= result+"<br>"+this.stocks[i].getHtmlDescription();
		}
		return result;
	}
}
