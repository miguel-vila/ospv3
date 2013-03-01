package co.s4n.osp;

import org.junit.Test;

import co.s4n.example.EventBusModule;
import co.s4n.example.SolicitudState;
import co.s4n.example.acl.SolicitudDTO;
import co.s4n.example.eventual.LogListener;
import co.s4n.example.eventual.SolicitudAprobada;
import co.s4n.example.eventual.SolicitudRechazada;
import co.s4n.example.states.EnEvaluacion;
import co.s4n.example.states.SolicitudStatesEnum;

import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class EventsTest {

	@Test
	public void testSimpleBus( ) {
		EventBus eb = new EventBus( "Test" );
		eb.register( new LogListener( ) );
		eb.post( new SolicitudAprobada( "101" ) );
		eb.post( new SolicitudRechazada( "456" ) );
	}
	
	@Test
	public void testSingletonEventBusInjection( ) {
		Injector injector = Guice.createInjector( new EventBusModule( ) );
		EnEvaluacion enEvaluacion = injector.getInstance( EnEvaluacion.class );
		enEvaluacion.getNextState( new SolicitudState( SolicitudStatesEnum.EN_EVALUACION.ordinal( ), new SolicitudDTO( "13883", "03005108130207521205", "030", Boolean.TRUE ) ) );
	}

}
