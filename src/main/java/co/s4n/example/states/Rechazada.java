package co.s4n.example.states;

import co.s4n.example.SolicitudState;
import co.s4n.osp.State;

public class Rechazada extends State< SolicitudState >  {

	public Rechazada( ) {
		super( "RECHAZADA" );
	}

	@Override
	public SolicitudState apply(SolicitudState entityState) {
		return null;
	}
}
