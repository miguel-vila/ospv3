package co.s4n.example;

import co.s4n.example.acl.SolicitudDTO;
import co.s4n.example.acl.SolicitudRepository;
import co.s4n.example.states.SolicitudStatesEnum;

public class SolicitudService {
	
	private final SolicitudRepository repository = new SolicitudRepository( );
	
	public void registrar( SolicitudDTO dto ) {
		SolicitudEntity solicitud = new SolicitudEntity( SolicitudStatesEnum.CREADA.ordinal( ), dto );
		repository.add( solicitud );
	}
	
	public void evaluar( SolicitudDTO dto ) {
		SolicitudEntity solicitud = repository.find( dto.nsolicitud( ) );
		solicitud.next( );
	}
	
	public void aprobar( SolicitudDTO dto ) {
		SolicitudEntity solicitud = repository.find( dto.nsolicitud( ) );
		solicitud.next( );
	}
	
	public void rechazar( SolicitudDTO dto ) {
		SolicitudEntity solicitud = repository.find( dto.nsolicitud( ) );
		solicitud.next( );		
	}
}
