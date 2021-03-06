package co.s4n.example;

import java.util.EnumMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;

import co.s4n.example.acl.SolicitudDTO;
import co.s4n.example.states.Aprobada;
import co.s4n.example.states.Creada;
import co.s4n.example.states.EnEvaluacion;
import co.s4n.example.states.Rechazada;
import co.s4n.example.states.SolicitudStatesEnum;
import co.s4n.osp.Entity;
import co.s4n.osp.EntityState;
import co.s4n.osp.State;

public class SolicitudEntity extends Entity< SolicitudState > {
	
	private Map< SolicitudStatesEnum, State<SolicitudState> > states = new EnumMap<>( SolicitudStatesEnum.class );
	
	public SolicitudEntity( Integer current, SolicitudDTO dto ) {
		super( new SolicitudState( current, dto ) );
		loadStates( );
	}

	public SolicitudEntity( SolicitudState solicitudState ) {
		super( solicitudState );
		loadStates( );
	}
	
	@Override
	public State< SolicitudState > currentState( ) {
		return states.get( SolicitudStatesEnum.values( )[ entityState.current( ) ] );
	}
		
	@Override
	public Entity<SolicitudState> getEntity(SolicitudState entityState) {
		return new SolicitudEntity(entityState);
	}
	
	private void loadStates( )  {
		states.put( SolicitudStatesEnum.CREADA, new Creada( ) );
		states.put( SolicitudStatesEnum.APROBADA, new Aprobada( ) );
		states.put( SolicitudStatesEnum.RECHAZADA, new Rechazada( ) );
		
		Injector injector = Guice.createInjector( new EventBusModule( ) );
		states.put( SolicitudStatesEnum.EN_EVALUACION, injector.getInstance( EnEvaluacion.class ) );
	}

}
