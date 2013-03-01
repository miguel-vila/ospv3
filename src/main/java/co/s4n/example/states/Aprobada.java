package co.s4n.example.states;

import java.util.HashSet;

import co.s4n.example.SolicitudState;
import co.s4n.osp.State;
import co.s4n.osp.Transition;

public class Aprobada extends State< SolicitudState >  {

	public Aprobada( ) {
		super( "APROBADA" );
		this.transitions = new HashSet<Transition<SolicitudState>>();
		transitions.add(new Transition<SolicitudState>() {
			
			@Override
			public SolicitudState newEntityState(SolicitudState currentState) {
				return currentState;
			}
			
			@Override
			public boolean applies(SolicitudState currentState) {
				return currentState.current( ) == SolicitudStatesEnum.EN_EVALUACION.ordinal( );
			}
		});
	}

}
