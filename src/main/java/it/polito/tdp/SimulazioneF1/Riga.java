package it.polito.tdp.SimulazioneF1;

public class Riga {

	private int aero;
	private int telaio;
	private int motore;
	private int aff;
	private String p1;
	private String p2;
	private String scuderia;

	public Riga(int aero, int telaio, int motore, int aff, String p1, String p2, String scuderia) {
		super();
		this.aero = aero;
		this.telaio = telaio;
		this.motore = motore;
		this.aff = aff;
		this.p1 = p1;
		this.p2 = p2;
		this.scuderia = scuderia;
	}

	public int getAero() {
		return aero;
	}

	public int getTelaio() {
		return telaio;
	}

	public int getMotore() {
		return motore;
	}

	public int getAff() {
		return aff;
	}

	public String getP1() {
		return p1;
	}

	public String getP2() {
		return p2;
	}

	public String getScuderia() {
		return scuderia;
	}
	
}
