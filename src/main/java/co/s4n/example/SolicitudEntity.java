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

public class SolicitudEntity implements Entity< SolicitudEntity > {
	
	private EntityState entityState;
	private Map< SolicitudStatesEnum, State< SolicitudState > > states = new EnumMap<>( SolicitudStatesEnum.class );
	
	public SolicitudEntity( Integer current, SolicitudDTO dto ) {
		super( );
		loadStates( );
		this.entityState = new SolicitudState( current, dto ); 
	}

	public SolicitudEntity( EntityState entityState ) {
		super( );
		loadStates( );
		this.entityState = entityState;
	}

	public SolicitudEntity next( ) {
		State< SolicitudState > currentState = states.get( SolicitudStatesEnum.values( )[ entityState.current( ) ] );
		EntityState newEntityState = currentState.apply( ( SolicitudState ) entityState );		
		return new SolicitudEntity( newEntityState );
	}
	
	public State<SolicitudState> currentState( ) {
		return states.get( SolicitudStatesEnum.values( )[ entityState.current( ) ] );
	}
	
	private void loadStates( )  {
		states.put( SolicitudStatesEnum.CREADA, new Creada( ) );
		states.put( SolicitudStatesEnum.APROBADA, new Aprobada( ) );
		states.put( SolicitudStatesEnum.RECHAZADA, new Rechazada( ) );
		
		Injector injector = Guice.createInjector( new EventBusModule( ) );
		states.put( SolicitudStatesEnum.EN_EVALUACION, injector.getInstance( EnEvaluacion.class ) );
	}
}
