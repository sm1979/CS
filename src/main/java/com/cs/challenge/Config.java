package com.cs.challenge;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	public static short getEventDurationLimit() throws IOException 
	{
		short eventDurationLimit;
		Properties prop = new Properties();
		try(FileReader reader = new FileReader("Config.properties"))
		{
			prop.load(reader);			
			eventDurationLimit = new Short(prop.getProperty("eventDurationLimit"));			
			
			
		} catch (IOException e) {			
			throw e;
		} 
		
		return eventDurationLimit;
	}

}
