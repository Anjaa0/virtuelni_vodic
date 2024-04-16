package me.fit.exception;

public class TuristaException extends Exception{

	private String mesage;

	public TuristaException(String mesage) {
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
