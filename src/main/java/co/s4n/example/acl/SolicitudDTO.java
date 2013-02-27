package co.s4n.example.acl;

public class SolicitudDTO {
	
	private final String nsolicitud;
	private final String ncotizacion;
	private final String cdramo;
	private final Boolean aprobada;
	
	public SolicitudDTO(String nsolicitud, String ncotizacion, String cdramo, Boolean aprobada) {
		super( );
		this.nsolicitud = nsolicitud;
		this.ncotizacion = ncotizacion;
		this.cdramo = cdramo;
		this.aprobada = aprobada;
	}

	public Boolean isAprobada( ) {
		return aprobada;
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
