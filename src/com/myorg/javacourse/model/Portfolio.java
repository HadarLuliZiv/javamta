package com.myorg.javacourse.model;

/**
 * The Portfolio class holds information about a portfolio, as well as a
 * stock array.
 * @author Lenovo
 *
 */
public class Portfolio {
	
	public enum ALGO_RECOMMENDATION{
		BUY, SELL, REMOVE, HOLD;
	}
	
	private final static int MAX_PORTFOLIO_SIZE=5;
	private String title;
	private int portfolioSize;
	private Stock[] stocks;
	private float balance;
	

	
	public float getBalance() {
		return this.balance;
	}

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
	/**
	 * The updateBalance method is responsible of updating the portfolio's
	 * balance. get's an amount, adds it to the balance and returns a boolean 
	 * result that indicates success.
	 * @param amount
	 * @return
	 */
	
	public Boolean updateBalance(float amount){
		
		float newBalance= this.balance+amount;
		
		if(newBalance<0){
			return false;
		}
		else{
			this.balance=newBalance;
			return true;
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
		for(int i=0; i<this.portfolioSize-1;i++){
			if(this.stocks[i].getSymbol().equals(stock.getSymbol())){
				return;
			}
		}
		
		if(this.portfolioSize < MAX_PORTFOLIO_SIZE){
			this.stocks[this.portfolioSize]=stock;
			this.stocks[this.portfolioSize].setStockQuantity(0);
			this.portfolioSize++;
		}
		else
			System.out.println("Can�t add new stock, portfolio can have only "+ this.getPortfolioSize()+" stocks");
	}
	/**
	 * The removeStock method is responsible of removing a stock from the stock's array:
	 * first it sells all stock's with the symbol it gets, then it removes the stock completely from the
	 * stock's array. 
	 * @param stock
	 */

	public Boolean removeStock(String stockSymbol){
		
		this.sellStock(stockSymbol, -1);

		for(int i=0; i <this.portfolioSize-1; i++)
		{
			if(this.stocks[i].getSymbol().equals(stockSymbol)){
				this.stocks[i]=this.stocks[this.portfolioSize-1];
				this.stocks[this.portfolioSize-1]=null;
				this.portfolioSize--;
				return true;
			}
		}	
		System.out.println("This stock is not at this portfolio!");
		return false;
	}
	/**
	 * The sellStock method gets a stock's symbol and quantity, and sells a stock 
	 * from the portfolio stock's array according to the parameters. if the quantity
	 * is -1, the method sells all stock quantity there is. 
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	
	public Boolean sellStock(String symbol, int quantity){
		
		if((quantity<0) && (quantity!=-1)){
			System.out.println("ERROR! quantity can't be negative!");
			return false;
		}
		
		for(int i=0; i <this.portfolioSize-1; i++)
		{				
			if(this.stocks[i].getSymbol().equals(symbol)){
				if(quantity==-1){
					this.updateBalance(this.stocks[i].getBid()*this.stocks[i].getStockQuantity());
					this.stocks[i].setStockQuantity(0);
					return true;
				}
				else{
					if(quantity<this.stocks[i].getStockQuantity()){
						System.out.println("Not enough stocks to sell!");
						return false;
					}
					else{
						this.updateBalance(quantity*this.stocks[i].getBid());
						this.stocks[i].setStockQuantity(this.stocks[i].getStockQuantity()-quantity);
						return true;
					}
				}
			}
		}
		System.out.println("Error! no such stock!");
		return false;
	}
	
	/**
	 * The buyStock method gets a stock and quantity and according to these 
	 * parameters, it buy's stocks (considering the balance in the portfolio).
	 * @param stock
	 * @param quantity
	 * @return
	 */
	public Boolean buyStock(Stock stock, int quantity){
		
		if((quantity<0) && (quantity!=-1)){
			System.out.println("ERROR! quantity can't be negative!");
			return false;
		}
		if(this.portfolioSize>0){
			for(int i=0; i <this.portfolioSize; i++){
				if(this.stocks[i].getSymbol().equals(stock.getSymbol())){
					break;
				}
				else{
					this.addStock(stock);
				}
			}
		}
		else{
			this.addStock(stock);
		}
			
			
		if(quantity==-1){
			int newQuantity=(int) ((this.getBalance()/stock.getAsk()));
			stock.setStockQuantity(stock.getStockQuantity()+newQuantity);
			this.updateBalance(-(newQuantity)*stock.getAsk());
			return true;
		}
		else{
			if(stock.getAsk()*quantity>this.getBalance()){
				System.out.println("Error! not enough balance to complete purchase!");
				return false;
			}
			else{
				stock.setStockQuantity(stock.getStockQuantity()+quantity);
				this.updateBalance(-(quantity)*stock.getAsk());
				return true;
			}
		}
	}
	
	/**
	 * The getStockValue is responsible of calculating the value of all
	 * stock's in the portfolio according to this calculation:
	 * stock's quantity*stock's bid value. then is sums all values and
	 * return a result.
	 * @return
	 */
	public float getStocksValue(){
		float result=0;
		for(int i=0; i <this.portfolioSize-1; i++){
			result+=(this.stocks[i].getBid()*this.stocks[i].getStockQuantity());
		}
		return result;
	}
	public float getTotalValue(){
		return this.getBalance()+this.getStocksValue();
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
		result+="<br>Total Portfolio Value: "+this.getTotalValue() +"$, Total Stocks value: "
		+this.getStocksValue()+"$, Balance: "+this.getBalance()+"$";
		for(int i=0; i<this.portfolioSize; i++){
			result= result+"<br>"+this.stocks[i].getHtmlDescription();
		}
		return result;
	}
}
