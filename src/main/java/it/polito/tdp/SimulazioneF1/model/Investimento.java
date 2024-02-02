package it.polito.tdp.SimulazioneF1.model;

public class Investimento {
	
	public Investimento(Scuderia s, int a, int t, int p, int m, int r) {
		double motore = m*0.09285*0.85/100;
		double aero = a*0.09285*1.12/100;
		double telaio = t*0.09285*1.15/100;
		System.out.println("aero: "+a+" telaio: "+t+" motore: "+m);
		System.out.println(s.getTag()+" - "+Math.round(s.getAerI()*1000)/1000.0+"   "+Math.round(s.getChaI()*1000)/1000.0+"   "+Math.round(s.getEngI()*1000)/1000.0+"  -  "+Math.round(s.getTotOVR()*1000)/1000.0);
		s.addAero(aero);
		s.addChass(telaio);
		s.addPower(motore);
	}

}
