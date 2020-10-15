package test.test;

import java.io.Serializable;

public class GtsRange implements Serializable{

	private static final long serialVersionUID = 1L;
	private String from;
	private String to;
	
	public GtsRange(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "GtsRange [from=" + from + ", to=" + to + "]";
	}
	
	
	
	
	
	
}
