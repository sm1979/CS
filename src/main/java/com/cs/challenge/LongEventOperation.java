package com.cs.challenge;

import java.io.IOException;
import java.util.List;

public class LongEventOperation implements EventOperation {
	
	Publisher publisher;
	
	public LongEventOperation(Publisher publisher)
	{
		this.publisher = publisher;
	}
	@Override
	
	// Get the long Event
	public void performOperation(List<LogEvent> logEventList) throws IOException 
	{
		short eventDurationLimit = Config.getEventDurationLimit();
		short timeDifference;	
		
		LogEvent logEvent1;
		LogEvent logEvent2;
		
		LogEvent longestLogEvent;	
		
		while(logEventList.size()>1) 
		{			
			logEvent1 = logEventList.get(0);
			logEvent2 = logEventList.get(1);			
			timeDifference =(Short) getTimeDifference(logEvent1.getTimestamp(), logEvent2.getTimestamp());
			
			
			if(timeDifference>eventDurationLimit)
			{
				longestLogEvent = logEvent1;
				publisher.publish(longestLogEvent);
			}	
			
			logEventList.remove(logEvent1);
			logEventList.remove(logEvent2);		
			
		}	
		
	}

	
	private short getTimeDifference(long timestamp1, long timestamp2) 
	{
		
		if(timestamp1>timestamp2)			
			return (short) (timestamp1-timestamp2);
		
		else			
			return (short) (timestamp2-timestamp1);		
		
	}

}
