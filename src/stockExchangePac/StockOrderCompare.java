/**
 * 
 */
package stockExchangePac;

import java.util.Comparator;

/**
 * @author tom
 *
 */
public class StockOrderCompare implements Comparator<StockOrder> {

	@Override
	public int compare(StockOrder o1, StockOrder o2) {
		if ((o1.getType() == "sellOrder") && (o2.getType() == "sellOrder")) {
			if (o1.getPrice() > o2.getPrice())
				return 1;
			else
				if (o1.getPrice() < o2.getPrice())
					return -1;
				else
					return o1.getClientName().compareTo(o2.getClientName());
		} else
			if ((o1.getType() == "buyOrder") && (o2.getType() == "buyOrder")) {
				if (o1.getPrice() < o2.getPrice())
					return 1;
				else
					if (o1.getPrice() > o2.getPrice())
						return -1;
					else
						return o1.getClientName().compareTo(o2.getClientName());
			} else
		return 0;
	}

}
