package co.s4n.example;

import co.s4n.example.acl.SolicitudDTO;
import co.s4n.osp.EntityState;

public class SolicitudState implements EntityState {
	
	private Integer current = 0;
	private final String nsolicitud;
	private final String ncotizacion;
	private final String cdramo;
	private final Boolean aprobada;
	
	public SolicitudState( Integer current, SolicitudDTO dto ) {
		super( );
		this.current = current;
		this.nsolicitud = dto.nsolicitud( );
		this.ncotizacion = dto.ncotizacion( );
		this.cdramo = dto.cdramo( );
		this.aprobada = dto.isAprobada( );
	}
	
	public SolicitudState( Integer current, String nsolicitud, String ncotizacion, String cdramo, Boolean aprobada ) {
		super( );
		this.current = current;
		this.nsolicitud = nsolicitud;
		this.ncotizacion = ncotizacion;
		this.cdramo = cdramo;
		this.aprobada = aprobada;
	}

	@Override
	public Integer current( ) {
		return current;
	}
	
	public Boolean isAprobada( ) {
		return this.aprobada;
	}
	
	public String nsolicitud( ) {
		return nsolicitud;
	}

	public String ncotizacion( ) {
		return ncotizacion;
	}

	public String cdramo( ) {
		return cdramo;
	}
}
