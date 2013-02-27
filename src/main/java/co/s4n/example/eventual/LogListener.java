package co.s4n.example.eventual;

import com.google.common.eventbus.Subscribe;

public class LogListener {
	
	@Subscribe
	public void listen( SolicitudAprobada event ) {
		System.out.println( event );
	}
	
	@Subscribe
	public void listen( SolicitudRechazada event ) {
		System.out.println( event );
	}
}
