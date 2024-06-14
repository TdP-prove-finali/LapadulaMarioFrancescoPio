package it.polito.tdp.model;

public class Investimento {
	
	public Investimento(Scuderia s, int a, int t, int m, int r, double Overall, double MaxDur) {
		double moltiplicatore = ((Overall/s.getTotOVR()-1)/2.5)+1;
		double motore = m*0.082143*0.85*moltiplicatore/100;
		double aero = a*0.082143*1.12*moltiplicatore/100;
		double telaio = t*0.082143*1.15*moltiplicatore/100;
		double moltiplicatoreDur = ((Overall/s.getTotOVR()-1)/2.5)+1;
		s.addAero(aero);
		s.addChass(telaio);
		s.addPower(motore);
		s.addDura(s.getDurability()*moltiplicatoreDur*r*7.142857/1000.0);
		}

}
