package com.cs.challenge;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface EventReader {
	
	public List<LogEvent> getLogEvents() throws IOException, JsonMappingException,JsonParseException;

}
