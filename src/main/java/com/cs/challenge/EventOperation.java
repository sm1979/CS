package com.cs.challenge;

import java.io.IOException;
import java.util.List;

public interface EventOperation 
{
	public void performOperation(List<LogEvent> logEventList) throws IOException;

}
