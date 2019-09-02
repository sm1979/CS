package com.cs.challenge;

public class ConsolePublisher implements Publisher {

	//Prints long event to the console
	@Override
	public void publish(LogEvent logEvent) {
		System.out.println("ALERT : Long event is : "+logEvent.getId());
		
	}

	

	
}
