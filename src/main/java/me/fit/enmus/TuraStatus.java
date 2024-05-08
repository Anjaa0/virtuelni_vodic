package me.fit.enmus;

public enum TuraStatus {
	
EXISTS("Tura već postoji");
	
	private String label;

	private TuraStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
