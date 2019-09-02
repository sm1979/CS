package com.cs.challenge;

public class LogEvent implements Comparable<LogEvent>
{
	
	private String id;
	private String state;
	private String type;
	private String host;
	private long timestamp;

	public LogEvent() 
	{
		
	}

	public LogEvent(String id, String state, String type, String host, long timestamp) 
	{		
		this.id = id;
		this.state = state;
		this.type = type;
		this.host = host;
		this.timestamp = timestamp;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int compareTo(LogEvent logEvent) 
	{
		if(logEvent== null)
			return -1;
		
		if(getId() == null && logEvent.getId()==null)
			return 0;
		
		else
			return getId().compareTo(logEvent.getId());
	}

	
	
	

}
