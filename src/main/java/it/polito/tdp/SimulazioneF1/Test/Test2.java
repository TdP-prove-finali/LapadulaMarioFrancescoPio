package it.polito.tdp.SimulazioneF1.Test;

import org.apache.commons.math3.distribution.NormalDistribution;

import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Scuderia;
import it.polito.tdp.SimulazioneF1.model.Track;

public class Test2 {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		Track t = model.getAllTracks().get(0);
		Pilota p11 = model.getAllPiloti().get(1);
		Pilota p2 = model.getAllPiloti().get(13);
		
		for(Pilota p : model.getAllPiloti()) {

			double index1 = (400-p.getAdaptability()-p.getControl()*2-p.getReactions()+p.getAggressivity()/2.25)/100000.0;
			
			System.out.println(p.getCognome() + " " + index1*100 + " "+ ((1-Math.pow((1-index1), 60))*100));
			
		}
		
		
		double indexa = 0.00136*1.5;
		double indexb = 0.0012750000000000003;
		System.out.println(indexa*100 + " "+ ((1-Math.pow((1-indexa), 60))*100));
		System.out.println(indexb*100 + " "+ ((1-Math.pow((1-indexb), 60))*100));*/
		
		double tt = 0;
		for(Track t : model.getAllTracks()) {
			tt += t.getOverI()+0.085;
			System.out.println(t.getNome()+"   "+(t.getOverI()+0.085));
		}
		
		System.out.println(tt/24.0);
		
		
		
		
		
	}

}
