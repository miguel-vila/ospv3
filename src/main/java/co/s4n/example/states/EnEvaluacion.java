package co.s4n.example.states;

import java.util.HashSet;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;

import co.s4n.example.SolicitudState;
import co.s4n.example.eventual.SolicitudAprobada;
import co.s4n.example.eventual.SolicitudRechazada;
import co.s4n.osp.State;
import co.s4n.osp.Transition;

public class EnEvaluacion extends State< SolicitudState >  {

	@Inject
	private EventBus eventBus; 
	
	public EnEvaluacion( ) {
		super( "EN_EVALUACION" );
		this.transitions = new HashSet<Transition<SolicitudState>>();
		transitions.add(new Transition<SolicitudState>() {
			
			@Override
			public SolicitudState newEntityState(SolicitudState currentState) {
				eventBus.post( new SolicitudAprobada( currentState.nsolicitud( ) ) );
				return new SolicitudState( SolicitudStatesEnum.APROBADA.ordinal( ), currentState.nsolicitud( ), currentState.ncotizacion( ), currentState.cdramo( ), currentState.isAprobada( ) );
			}
			
			@Override
			public boolean applies(SolicitudState currentState) {
				return currentState.current( ) == SolicitudStatesEnum.EN_EVALUACION.ordinal( ) && currentState.isAprobada( );
			}
		});
		transitions.add(new Transition<SolicitudState>() {
			
			@Override
			public SolicitudState newEntityState(SolicitudState currentState) {
				eventBus.post( new SolicitudRechazada( currentState.nsolicitud( ) ) );
				return new SolicitudState( SolicitudStatesEnum.RECHAZADA.ordinal( ), currentState.nsolicitud( ), currentState.ncotizacion( ), currentState.cdramo( ), currentState.isAprobada( ) );
			}
			
			@Override
			public boolean applies(SolicitudState currentState) {
				return currentState.current( ) == SolicitudStatesEnum.EN_EVALUACION.ordinal( ) && !currentState.isAprobada( );
			}
		});
	}

}
