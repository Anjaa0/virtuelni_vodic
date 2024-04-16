package me.fit.enmus;

public enum TuristaStatus{

	EXISTS("Turista već postoji");
	
	private String label;

	private TuristaStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
