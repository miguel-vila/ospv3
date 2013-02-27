package co.s4n.example.states;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;

import co.s4n.example.SolicitudState;
import co.s4n.example.eventual.SolicitudAprobada;
import co.s4n.example.eventual.SolicitudRechazada;
import co.s4n.osp.State;

public class EnEvaluacion extends State< SolicitudState >  {

	@Inject
	private EventBus eventBus; 
	
	public EnEvaluacion( ) {
		super( "EN_EVALUACION" );
	}

	@Override
	public SolicitudState apply( SolicitudState entityState ) {
		if( entityState.current( ) == SolicitudStatesEnum.EN_EVALUACION.ordinal( ) )
			if( entityState.isAprobada( ) ) {
				eventBus.post( new SolicitudAprobada( entityState.nsolicitud( ) ) );
				return new SolicitudState( SolicitudStatesEnum.APROBADA.ordinal( ), entityState.nsolicitud( ), entityState.ncotizacion( ), entityState.cdramo( ), entityState.isAprobada( ) );
			}
			else {
				eventBus.post( new SolicitudRechazada( entityState.nsolicitud( ) ) );
				return new SolicitudState( SolicitudStatesEnum.RECHAZADA.ordinal( ), entityState.nsolicitud( ), entityState.ncotizacion( ), entityState.cdramo( ), entityState.isAprobada( ) );
			}
		else
			throw new RuntimeException( "La Solicitud no se puede evaluar porque se encuentra en estado " + SolicitudStatesEnum.values()[ entityState.current( ) ].name( ) );
	}
}
