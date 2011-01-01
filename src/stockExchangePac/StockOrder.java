/**
 * 
 */
package stockExchangePac;

import brokerPac.StockOrder;

/**
 * @author tom
 *
 */
public class StockOrder {	
	private final String _type;
	private final int _amount;
	private final String _stockname; 
	private final String _clientName;
	private final String _brokerName;
	private final double _price;
	
	/**
	 * a StockOrder constructor 
	 * @param type type of order buy/sell
	 * @param amount amount of stocks
	 * @param name the name of the stock or the name of the client how made the order
	 * @param price price of the stock
	 */
	public StockOrder(String type,String clientName,String brokerName,int amount,String stockname,double price) {
		_type=type;
		_amount=amount;
		_stockname=stockname;
		_clientName=clientName;
		_brokerName=brokerName;
		_price=price;
	}
	
	/**
	 * returns {@link StockOrder} type
	 * @return type
	 */
	public String getType() {
		return _type;
	}
	
	/**
	 * returns {@link StockOrder} amount
	 * @return amount
	 */
	public int getAmount() {
		return _amount;
	}
	
	/**
	 * returns {@link StockOrder} stockName
	 * @return stock's name
	 */
	public String getStockName() {
		return _stockname;
	}
	
	/**
	 * returns {@link StockOrder} clientName
	 * @return client's name
	 */
	public String getClientName() {
		return _clientName;
	}
	
	/**
	 * returns {@link StockOrder} broker Name
	 * @return broker's name
	 */
	public String getBrokerName() {
		return _brokerName;
	}
	
	/**
	 * returns {@link StockOrder} the price stated in the order
	 * @return stock's wanted price
	 */
	public double getPrice() {
		return _price;
	}
	
	/**
	 * returns {@link StockOrder} a string with all the order's info
	 * @return a string
	 */
	public String toString() {
		return _type+" "+ _clientName + " "+_brokerName +" "+ _amount + " " + _stockname + " " + _price;
	}

}
