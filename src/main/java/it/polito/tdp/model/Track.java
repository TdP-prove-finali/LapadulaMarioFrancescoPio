package it.polito.tdp.model;

public class Track {
	
	int Id;
	String nome;
	String nazione;
	String Località;
	double PowerI;
	double AeroI;
	double ChasI;
	double AC;
	double AP;
	double CP;
	double TryeI;
	double OverI;
	double RainProbability;
	int NGiri;
	double TempoMedioGiro;
	int TempoPitLane;

	public Track(int id, String nome, String nazione, String località, double powerI, double aeroI, double chasI, double d, double e, double f, double tryeI, double rainProbability,  int nGiri, double TLap, int TPit) {
		super();
		Id = id;
		this.nome = nome;
		this.nazione = nazione;
		Località = località;
		PowerI = powerI;
		AeroI = aeroI;
		ChasI = chasI;
		AC = d;
		AP = e;
		CP = f;
		TryeI = tryeI;
		RainProbability = rainProbability;
		NGiri = nGiri;
		this.TempoMedioGiro = TLap;
		this.TempoPitLane = TPit;
	}
	
	public void setOverI(double overI) {
		OverI = overI+0.085;
	}
	
	public int getId() {
		return Id;
	}
	public String getNome() {
		return nome;
	}
	public String getNazione() {
		return nazione;
	}
	public String getLocalità() {
		return Località;
	}
	public double getPowerI() {
		return PowerI;
	}
	public double getAeroI() {
		return AeroI;
	}
	public double getChasI() {
		return ChasI;
	}
	public double getTryeI() {
		return TryeI;
	}
	public double getOverI() {
		return OverI;
	}
	public double getRainProbability() {
		return RainProbability;
	}

	public double getAC() {
		return AC;
	}

	public double getAP() {
		return AP;
	}

	public double getCP() {
		return CP;
	}

	public int getNGiri() {
		return NGiri;
	}
	
	public double getTempoMedioGiro() {
		return TempoMedioGiro;
	}

	public int getTempoPitLane() {
		return TempoPitLane;
	}

	public double CalcolaPrestazioneScuderia(Scuderia s) {
		double PrestazioneScuderia = s.getAerI()*this.getAeroI()+s.getChaI()*this.getChasI()+s.getEngI()*this.getPowerI()+this.getAC()*s.getAerI()*s.getChaI()+this.getAP()*s.getAerI()*s.getEngI()+this.getCP()*s.getEngI()*s.getChaI();
		return PrestazioneScuderia;
	}

	@Override
	public String toString() {
		return "Track [Id=" + Id + ", nome=" + nome + ", nazione=" + nazione + ", Località=" + Località + ", PowerI="
				+ PowerI + ", AeroI=" + AeroI + ", ChasI=" + ChasI + ", TryeI=" + TryeI + ", OverI=" + OverI
				+ ", RainProbability=" + RainProbability + ", NGiri=" + NGiri + "]";
	}
	
	

}
