package co.s4n.osp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import co.s4n.example.SolicitudEntity;
import co.s4n.example.SolicitudState;
import co.s4n.example.acl.SolicitudDTO;
import co.s4n.example.states.SolicitudStatesEnum;

public class SolicitudTest {

	@Test
	public void testLifeCycle_Aprobada( ) {
		SolicitudEntity nuevaSolicitud = new SolicitudEntity( SolicitudStatesEnum.CREADA.ordinal( ), new SolicitudDTO( "13883", "03005108130207521205", "030", Boolean.TRUE ) );
		
		State< SolicitudState > currentState = nuevaSolicitud.currentState( );
		assertTrue( "CREADA".equals( currentState.name( ) ) );
		
		SolicitudEntity solicitudEnEvaluacion = nuevaSolicitud.next( );
		assertTrue( "EN_EVALUACION".equals( solicitudEnEvaluacion.currentState( ).name( ) ) );
		
		SolicitudEntity solicitudAProbada = solicitudEnEvaluacion.next( );
		assertTrue( "APROBADA".equals( solicitudAProbada.currentState( ).name( ) ) );
	}

	@Test
	public void testLifeCycle_Rechazada( ) {
		SolicitudEntity nuevaSolicitud = new SolicitudEntity( SolicitudStatesEnum.CREADA.ordinal( ), new SolicitudDTO( "13883", "03005108130207521205", "030", Boolean.FALSE ) );
		
		State< SolicitudState > currentState = nuevaSolicitud.currentState( );
		assertTrue( "CREADA".equals( currentState.name( ) ) );
		
		SolicitudEntity solicitudEnEvaluacion = nuevaSolicitud.next( );
		assertTrue( "EN_EVALUACION".equals( solicitudEnEvaluacion.currentState( ).name( ) ) );
		
		SolicitudEntity solicitudAProbada = solicitudEnEvaluacion.next( );
		assertTrue( "RECHAZADA".equals( solicitudAProbada.currentState( ).name( ) ) );
	}
}
