/**
 * a {@link Comparator} of the {@link StockExchangeBroker}
 */
package stockExchangePac;

import java.util.Comparator;

/**
 * 
 * @author tom

 */
public class BrokerCompare implements Comparator<StockExchangeBroker> {

	@Override
	public int compare(StockExchangeBroker o1, StockExchangeBroker o2) {
		if (o1.getNumOfClients() > o2.getNumOfClients())
			return 1;
		else  {
			if (o1.getNumOfClients() < o2.getNumOfClients())
				return -1;
		 else
			return o1.getName().compareTo(o2.getName());
		}
	}

}
