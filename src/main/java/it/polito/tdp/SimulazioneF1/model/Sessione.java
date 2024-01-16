package it.polito.tdp.SimulazioneF1.model;

public class Sessione {
	
	enum evento{
		QUALIFICA,
		GARA
	}
	
	evento type;
	Track n;
	
	public Sessione(Track n, evento type) {
		super();
		this.n = n;
		this.type = type;
	}

	public evento getType() {
		return type;
	}

	public Track getN() {
		return n;
	}
	
	
	
	
	
	

}
