/**
 * 
 */
package stockExchangePac;

import java.io.IOException;

import javax.security.auth.login.LoginException;

/**
 * @author tom
 *
 */
public class StartStockExchange {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws LoginException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, LoginException, IOException {
		StockExchange stockExchange=new StockExchange(args[0],Integer.parseInt(args[1]));
		stockExchange.startNewDay();

	}

}
