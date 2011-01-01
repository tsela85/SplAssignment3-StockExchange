/**
 * 
 */
package stockExchangePac;

import java.util.Vector;

/**
 * @author tom
 * @info a object representing a broker in the stockExchnage 
 */

public class StockExchangeBroker { 
	private final String _name;
	Vector<String> _clients;

	/**
	 * a new {@link StockExchangeBroker}
	 * @param name 
	 */
	public StockExchangeBroker(String name) {
		_name=name;
		_clients=new Vector<String>();
	}

//	void incClientNum() {
//		_numOfClients++;
//	}
//
//	void decClientNum() {
//		_numOfClients--;
//	}
	void addClient(String client) {
		_clients.add(client);
	}
	
	void removeClient(String client) {
		_clients.remove(client);
	}

	String getName() {
		return _name;
	}

	int getNumOfClients() {
		return _clients.size();
	}


}
