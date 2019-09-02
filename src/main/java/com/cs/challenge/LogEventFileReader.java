package com.cs.challenge;

import com.cs.challenge.EventReader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogEventFileReader implements EventReader {
	
	String inputFile;
	public LogEventFileReader(String inputFile) 
	{
		this.inputFile = inputFile;
		
	}

	//Reads log events from the file and stores in list
	@Override
	public List<LogEvent> getLogEvents() throws  IOException, JsonMappingException,JsonParseException
	{
		ObjectMapper mapper = new ObjectMapper();
		List<LogEvent> logEventList = new ArrayList<LogEvent>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			String currentLine;
			while((currentLine = br.readLine())!=null) 
			{
				LogEvent logEvent = mapper.readValue(currentLine, LogEvent.class);
				logEventList.add(logEvent);			
				
			}				
			
			Collections.sort(logEventList);			
		}		
		
		
		return logEventList;
	}

}
