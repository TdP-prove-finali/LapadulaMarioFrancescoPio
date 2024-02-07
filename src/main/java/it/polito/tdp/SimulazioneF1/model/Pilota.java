package it.polito.tdp.SimulazioneF1.model;

import java.util.Objects;

public class Pilota implements Comparable<Pilota>{
	
	int ID;
	String nome;
	String cognome;
	String nazione;
	Scuderia s;
	int GPs;
	double ovr;
	double reactions;
	double control;
	double smoothness;
	double adaptability;
	double overtaking;
	double defending;
	double aggressivity;
	
	public Pilota(int iD, String nome, String cognome, String nazione, int gPs, double ovr, double reactions,
			double control, double smoothness, double adaptability, double overtaking, double defending,
			double aggressivity) {
		super();
		ID = iD;
		this.nome = nome;
		this.cognome = cognome;
		this.nazione = nazione;
		GPs = gPs;
		this.ovr = ovr;
		this.reactions = reactions;
		this.control = control;
		this.smoothness = smoothness;
		this.adaptability = adaptability;
		this.overtaking = overtaking;
		this.defending = defending;
		this.aggressivity = aggressivity;
	}

	public int getID() {
		return ID;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNazione() {
		return nazione;
	}

	public Scuderia getS() {
		return s;
	}

	public int getGPs() {
		return GPs;
	}

	public double getOvr() {
		return ovr;
	}

	public double getReactions() {
		return reactions;
	}

	public double getControl() {
		return control;
	}

	public double getSmoothness() {
		return smoothness;
	}

	public double getAdaptability() {
		return adaptability;
	}

	public double getOvertaking() {
		return overtaking;
	}

	public double getDefending() {
		return defending;
	}

	public double getAggressivity() {
		return aggressivity;
	}

	public void setS(Scuderia s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return this.getNome()+" "+this.getCognome();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pilota other = (Pilota) obj;
		return ID == other.ID;
	}

	@Override
	public int compareTo(Pilota o) {
		return this.getID()-o.getID();
	}
	
	
	
	
	
	
	

}
