package co.s4n.osp;

public abstract class Transition< T extends EntityState > {

	public abstract T newEntityState(T currentState);
	
	public abstract boolean applies(T currentState);
	
}
