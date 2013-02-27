package co.s4n.example.acl;

import co.s4n.example.SolicitudEntity;
import co.s4n.example.states.SolicitudStatesEnum;

public class SolicitudRepository {
	
	public void add( SolicitudEntity entity ) {
		System.out.println( "Solicitud " + entity.currentState( ) + " guardada." );
	}
	
	public void remove( SolicitudEntity entity ) {
		System.out.println( "Solicitud " + entity.currentState( ) + " eliminada." );
	}
	
	public void replace( SolicitudEntity entity ) {
		System.out.println( "Solicitud " + entity.currentState( ) + " actualizada." );
	}
	
	public SolicitudEntity find( String nsolicitud ) {
		return new SolicitudEntity( SolicitudStatesEnum.CREADA.ordinal( ), new SolicitudDTO( "13883", "03005108130207521205", "030", Boolean.TRUE ) );
	}
}
