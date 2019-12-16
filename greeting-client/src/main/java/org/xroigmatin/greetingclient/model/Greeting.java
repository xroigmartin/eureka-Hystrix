package org.xroigmatin.greetingclient.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Greeting")
public class Greeting implements Serializable{
	
	private static final long serialVersionUID = 8731995475311196825L;

	private final String content;
	
	protected Greeting() {
		this.content = "Hello!";
	}
	
	public Greeting(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}
