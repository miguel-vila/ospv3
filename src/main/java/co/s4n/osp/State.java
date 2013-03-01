package co.s4n.osp;

import java.util.Collection;

public abstract class State<T extends EntityState> {
	
	protected String name;
	
	protected Collection<Transition<T>> transitions;
	
	public State( String name, Collection<Transition<T>> transitions) {
		super();
		this.name = name;
		this.transitions = transitions;
	}
	
	public State( String name ) {
		super();
		this.name = name;
	}

	public String name( ) {
		return name;
	}
	
	public T getNextState( T entityState ){
		T result = null;
		for(Transition<T> transition : transitions){
			if( transition.applies( entityState ) ){
				if(result!=null)
					throw new RuntimeException("Dos transiciones no pueden aplicar simultaneamente");
				result = transition.newEntityState( entityState );
			}
		}
		if(result==null)
			throw new RuntimeException("Debe aplicar por lo menos una transicion");
		return result;
	}
}
