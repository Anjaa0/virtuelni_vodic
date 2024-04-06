package me.fit.exception;

public class VodicException extends Exception {

	private String message;

	public VodicException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
