package co.s4n.example.eventual;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SolicitudRechazada {
	private Long timestamp;
	private String message;

	public SolicitudRechazada( String nsolicitud ) {
		super();
		this.timestamp = System.currentTimeMillis( );
		this.message = "La solicitud " + nsolicitud + " fue rechazada.";
	}

	public Long timestamp( ) {
		return timestamp;
	}
	
	@Override
	public String toString( ) {
		Calendar calendar = Calendar.getInstance( );
		calendar.setTimeInMillis( timestamp );
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssz" );
		return sdf.format( calendar.getTime( ) ) + " - " + message;
	}
}
