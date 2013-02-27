package co.s4n.example.states;

import co.s4n.example.SolicitudState;
import co.s4n.osp.State;

public class Aprobada extends State< SolicitudState >  {

	public Aprobada( ) {
		super( "APROBADA" );
	}

	@Override
	public SolicitudState apply( SolicitudState entityState ) {
		if( entityState.current( ) == SolicitudStatesEnum.EN_EVALUACION.ordinal( ) )
			return entityState;
		else
			throw new RuntimeException( "La Solicitud no se puede evaluar porque se encuentra en estado " + SolicitudStatesEnum.values()[ entityState.current( ) ].name( ) + " y deberia estar EN_EVALUACION" );
	}
}
