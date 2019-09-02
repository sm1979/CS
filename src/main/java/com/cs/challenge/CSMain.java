package com.cs.challenge;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CSMain {
	
	public static void main(String[] args) {
		String inputFile;		
		
		if(args.length!=0)
		{
			inputFile = args[0];				
			
			try 
			{					
				new CSMain().run(inputFile);
			} 
			catch (Exception e) 
			{					
				e.printStackTrace();
				System.exit(-1);
			}			
		}
		else
		{
			System.out.println("Please provide the input file.");
		}			

	}

	private void run(String inputFile) throws JsonMappingException, JsonParseException, IOException 
	{		
		EventReader eventReaderFromFile = new LogEventFileReader(inputFile);
		Publisher consolePublisher = new ConsolePublisher();
		EventOperation longestEvent = new LongEventOperation(consolePublisher);
				
		// Get list of LogEvents from file
		List<LogEvent> logEventList = eventReaderFromFile.getLogEvents();
		
		// Get longest Event
		longestEvent.performOperation(logEventList);	
		
	}

}
