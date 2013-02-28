package co.s4n.osp;

public abstract class State<T extends EntityState> {
	
	private String name;
	
	public State( String name ) {
		super();
		this.name = name;
	}

	public String name( ) {
		return name;
	}
	
	public abstract T apply( T entityState );
}
