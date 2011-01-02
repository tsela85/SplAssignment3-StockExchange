/**
 * 
 */
package Stomp;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * @author lxmonk
 * 
 */
public class OurFormatter extends SimpleFormatter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	 */
	@Override
	public String format(LogRecord record) {
		return this.formatMessage(record) + "\n";
	}

}
