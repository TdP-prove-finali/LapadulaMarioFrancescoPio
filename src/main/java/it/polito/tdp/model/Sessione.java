package it.polito.tdp.model;

public class Sessione implements Comparable<Sessione>{
	
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


	@Override
	public int compareTo(Sessione o) {
		if(this.getN().equals(o.getN())) {
			if(this.getType()==evento.QUALIFICA) {
				return -1;
			}else {
				return 1;
			}
		}else {
			return this.getN().getId()-o.getN().getId();
		}
	}
	
	
	
	
	
	

}
