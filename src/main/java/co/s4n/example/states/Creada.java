package co.s4n.example.states;

import co.s4n.example.SolicitudState;
import co.s4n.osp.State;

public class Creada extends State< SolicitudState > {

	public Creada( ) {
		super( "CREADA" );		
	}
	
	@Override
	public SolicitudState apply( SolicitudState entityState ) {
		SolicitudState newEntityState = new SolicitudState( SolicitudStatesEnum.EN_EVALUACION.ordinal( ), entityState.nsolicitud( ), entityState.ncotizacion( ), entityState.cdramo( ), entityState.isAprobada( ) );  
		return newEntityState;
	}

}
