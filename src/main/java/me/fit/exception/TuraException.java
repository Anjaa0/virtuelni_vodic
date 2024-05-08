package me.fit.exception;

public class TuraException extends Exception{

	private String mesage;

	public TuraException(String mesage) {
		super();
		this.mesage = mesage;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
	
}
