package it.polito.tdp.SimulazioneF1;

public class Riga {

	private int aero;
	private int telaio;
	private int motore;
	private int aff;
	private int punti1;
	private int punti2;
	private int puntiS;
	private int pos1;
	private int pos2;
	private int posS;
	private String tag1;
	private String tag2;
	private String tagS;

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

	public Riga(int aero, int telaio, int motore, int aff, int punti1, int punti2, int puntiS, int pos1, int pos2,
			int posS, String tag1, String tag2, String tagS) {
		super();
		this.aero = aero;
		this.telaio = telaio;
		this.motore = motore;
		this.aff = aff;
		this.punti1 = punti1;
		this.punti2 = punti2;
		this.puntiS = puntiS;
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.posS = posS;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tagS = tagS;
	}

	public int getPunti1() {
		return punti1;
	}

	public int getPunti2() {
		return punti2;
	}

	public int getPuntiS() {
		return puntiS;
	}

	public int getPos1() {
		return pos1;
	}

	public int getPos2() {
		return pos2;
	}

	public int getPosS() {
		return posS;
	}

	public String getTag1() {
		return tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public String getTagS() {
		return tagS;
	}
		
}
