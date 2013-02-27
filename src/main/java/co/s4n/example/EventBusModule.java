package co.s4n.example;

import co.s4n.example.eventual.LogListener;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
 
public class EventBusModule extends AbstractModule {

	@Override
	protected void configure( ) {
	}
	
	@Provides @Singleton 
	EventBus provideEventBus( ) {
		EventBus eb = new EventBus( "EventBus" );
		eb.register( new LogListener( ) );
		return eb;
	}

}
