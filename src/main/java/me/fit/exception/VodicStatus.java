package me.fit.exception;

public enum VodicStatus {

	EXISTS("Vodic vec postoji");
	
	private String label;

	private VodicStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
}
