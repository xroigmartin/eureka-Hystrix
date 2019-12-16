package org.xroigmatin.greetingserver.model;

import java.io.Serializable;

public class Greeting implements Serializable{
	
	private static final long serialVersionUID = 8731995475311196825L;

	private final String content;
	
	public Greeting(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}