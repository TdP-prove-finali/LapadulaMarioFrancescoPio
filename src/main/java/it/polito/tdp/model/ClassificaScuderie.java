package it.polito.tdp.SimulazioneF1.model;

public class ClassificaScuderie {
	
	int cod;
	Scuderia s;
	int punti;
	int vittorie;
	
	public ClassificaScuderie(int cod, Scuderia s, int punti, int vittorie) {
		super();
		this.cod = cod;
		this.s = s;
		this.punti = punti;
		this.vittorie = vittorie;
	}

	public int getVittorie() {
		return vittorie;
	}

	public void setVittorie(int vittorie) {
		this.vittorie = vittorie;
	}

	public int getCod() {
		return cod;
	}

	public Scuderia getS() {
		return s;
	}

	public int getPunti() {
		return punti;
	}
	
	
	

}
