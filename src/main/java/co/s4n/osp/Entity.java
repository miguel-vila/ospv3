package co.s4n.osp;

public abstract class Entity< T extends EntityState > {

	protected T entityState;
	
	public Entity(T entityState){
		this.entityState = entityState;
	}
	
	public Entity<T> next( ) {
		State<T> currentState = currentState();
		T newEntityState = currentState.apply( entityState );		
		return getEntity( newEntityState );
	}
	
	public abstract State<T> currentState( );
	
	public EntityState entityState(){
		return entityState;
	}
	
	public abstract Entity<T> getEntity(T entityState);
	
}
