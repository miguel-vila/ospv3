package co.s4n.example.states;

import java.util.HashSet;

import co.s4n.example.SolicitudState;
import co.s4n.osp.State;
import co.s4n.osp.Transition;

public class Creada extends State< SolicitudState > {			
	
	public Creada( ) {
		super( "CREADA" );
		this.transitions = new HashSet<Transition<SolicitudState>>();
		transitions.add(new Transition<SolicitudState>() {
			
			@Override
			public boolean applies(SolicitudState currentState) {
				return true;
			}

			@Override
			public SolicitudState newEntityState(SolicitudState currentState) {
				SolicitudState newEntityState = new SolicitudState( SolicitudStatesEnum.EN_EVALUACION.ordinal( ), currentState.nsolicitud( ), currentState.ncotizacion( ), currentState.cdramo( ), currentState.isAprobada( ) );  
				return newEntityState;
			}
		});
	}

}
