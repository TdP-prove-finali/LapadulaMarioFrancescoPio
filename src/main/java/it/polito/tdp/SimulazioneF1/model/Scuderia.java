package it.polito.tdp.SimulazioneF1.model;

public class Scuderia {
	
	int id;
	String name;
	String tag;
	int PilotaID1;
	int PilotaID2;
	double RaceEngineerValue;
	double TechnicalChiefValue;
	double HeadofAerodynamicsValue;
	double SportingDirectorValue;
	double PitCrewValue;
	double PitTime;
	double durability;
	double chassis;
	double aerodynamics;
	double powertrains;
	
	//Driver P1;
	//Driver P2;
	double aerI;
	double chaI;
	double engI;
	
	public Scuderia(int id, String name, String tag, int pilotaID1, int pilotaID2, double raceEngineerValue,
			double technicalChiefValue, double headofAerodynamicsValue, double sportingDirectorValue,
			double pitCrewValue, double pitTime, double durability, double chassis, double aerodynamics,
			double powertrains) {
		super();
		this.id = id;
		this.name = name;
		this.tag = tag;
		PilotaID1 = pilotaID1;
		PilotaID2 = pilotaID2;
		RaceEngineerValue = raceEngineerValue/100;
		TechnicalChiefValue = technicalChiefValue/100;
		HeadofAerodynamicsValue = headofAerodynamicsValue/100;
		SportingDirectorValue = sportingDirectorValue/100;
		PitCrewValue = pitCrewValue/100;
		PitTime = pitTime;
		this.durability = durability;
		this.chassis = chassis;
		this.aerodynamics = aerodynamics;
		this.powertrains = powertrains;
		this.calcolaI();
		
	}
	
	private void calcolaI() {
		this.aerI = aerodynamics*0.8+HeadofAerodynamicsValue*0.2;
		this.chaI = this.chassis*0.8+TechnicalChiefValue*0.2;
		this.engI = this.powertrains;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTag() {
		return tag;
	}

	public int getPilotaID1() {
		return PilotaID1;
	}

	public int getPilotaID2() {
		return PilotaID2;
	}

	public double getRaceEngineerValue() {
		return RaceEngineerValue;
	}

	public double getTechnicalChiefValue() {
		return TechnicalChiefValue;
	}

	public double getHeadofAerodynamicsValue() {
		return HeadofAerodynamicsValue;
	}

	public double getSportingDirectorValue() {
		return SportingDirectorValue;
	}

	public double getPitCrewValue() {
		return PitCrewValue;
	}

	public double getPitTime() {
		return PitTime;
	}

	public double getDurability() {
		return durability;
	}

	public double getChassis() {
		return chassis;
	}

	public double getAerodynamics() {
		return aerodynamics;
	}

	public double getPowertrains() {
		return powertrains;
	}

	public double getAerI() {
		return aerI;
	}

	public double getChaI() {
		return chaI;
	}

	public double getEngI() {
		return engI;
	}
	
	public double getTotOVR() {
		return this.chaI+this.aerI+this.engI;
	}

	public void addChass(double d) {
		this.chaI += d;
	}
	
	public void addDura(double d) {
		this.durability += d;
	}
	
	public void addPower(double d) {
		this.engI += d;
	}
	
	public void addAero(double d) {
		this.aerI += d;
	}
	
	//ANCORA DA SVILUPPARE
	public void addPit(double d) {
		this.aerI += d;
	}
	
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	
	
	

}
