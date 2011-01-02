package Stomp;

import java.util.Map;
import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.net.Socket;
import javax.security.auth.login.LoginException;

/**
 * Implements a Stomp client connection to a Stomp server via the network.
 * 
 * Example:
 * 
 * <pre>
 *   Client c = new Client( "localhost", 61626, "ser", "ser" );
 *   c.subscribe( "/my/channel", new Listener() { ... } );
 *   c.subscribe( "/my/other/channel", new Listener() { ... } );
 *   c.send( "/other/channel", "Some message" );
 *   // ...
 *   c.disconnect();
 * </pre>
 * 
 * @see Stomp
 * 
 *      (c)2005 Sean Russell
 */
public class Client extends Stomp implements MessageReceiver {
	private Thread _listener;
	private OutputStream _output;
	private InputStream _input;
	private Socket _socket;
	public Logger _logger;

	/**
	 * Connects to a server
	 * 
	 * Example:
	 * 
	 * <pre>
	 *   Client stomp_client = new Client( "host.com", 61626 );
	 *   stomp_client.subscribe( "/my/messages" );
	 *   ...
	 * </pre>
	 * 
	 * @see Stomp
	 * @param server
	 *            The IP or host name of the server
	 * @param port
	 *            The port the server is listening on
	 */
	public Client(String server, int port, String login, String pass)
			throws IOException, LoginException {
		_socket = new Socket(server, port);
		_input = _socket.getInputStream();
		_output = _socket.getOutputStream();

		_listener = new Receiver(this, _input);
		_listener.start();

		// Connect to the server
		HashMap header = new HashMap();
		header.put("login", login);
		header.put("passcode", pass);
		transmit(Command.CONNECT, header, null);
		try {
			String error = null;
			while (!isConnected() && ((error = nextError()) == null)) {
				Thread.sleep(100);
			}
			if (error != null)
				throw new LoginException(error);
		} catch (InterruptedException e) {
		}
		/* create the logger */
		_logger = Logger.getLogger("SplAssignment3.Logger");
		// Logger logger = new Logg ("SplAssignment1.Logger");
		Handler fh = null;
		try {
			fh = new FileHandler(login + ".log");
		} catch (IOException e) {
			e.printStackTrace();
		}
		_logger.setUseParentHandlers(false);

		// logger output is written to a file in fh handler
		fh.setFormatter(new OurFormatter());
		_logger.addHandler(fh);

		// Set the log level specifying which message levels will be logged by
		// this logger
		_logger.setLevel(Level.INFO);
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.OFF);
		_logger.addHandler(ch);

		/* start the logger */
		_logger.fine("logger started.");
	}

	public boolean isClosed() {
		return _socket.isClosed();
	}

	public void disconnect(Map header) {
		if (!isConnected())
			return;
		transmit(Command.DISCONNECT, header, null);
		_listener.interrupt();
		Thread.yield();
		try {
			_input.close();
		} catch (IOException e) {/* We ignore these. */
		}
		try {
			_output.close();
		} catch (IOException e) {/* We ignore these. */
		}
		try {
			_socket.close();
		} catch (IOException e) {/* We ignore these. */
		}
		_connected = false;
	}

	/**
	 * Transmit a message to the server
	 */
	public void transmit(Command c, Map h, String b) {
		try {
			Transmitter.transmit(c, h, b, _output);
		} catch (Exception e) {
			receive(Command.ERROR, null, e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see Stomp.Stomp#send(java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String dest, String mesg) {
		//log the message sent.
		_logger.severe("\nMessage sent:\ndestination:" + dest + "\n\n" + mesg + "\n");
		super.send(dest, mesg);
	}
	
	
}
