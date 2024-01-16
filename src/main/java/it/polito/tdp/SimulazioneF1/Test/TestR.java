package it.polito.tdp.SimulazioneF1.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.distribution.NormalDistribution;

import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Track;

public class TestR {

	public static void main(String[] args) {
		
		Model model = new Model();
		Track t = model.getAllTracks().get(2);
		
		
		 
		double m1 = 0.0;
		double m2 = Double.MAX_VALUE;
		
		for(Pilota p : model.getAllPiloti()) {
        	double d1 = t.CalcolaPrestazioneScuderia(p.getS());
        	double d2 = p.getOvr()/100.0;
        	double d3 = d1*0.71 + d2*0.29;
        	if(d3>m1) {
        		m1 = d3;
        	}
        	if(d3 < m2) {
        		m2 = d3;
        	}
        	
        	System.out.println(p.getCognome()+" "+Math.round(d3*1000)/1000.0+"   ("+Math.round(d1*1000)/1000.0+"-"+Math.round(d2*1000)/1000.0+")");
        }
		
		double avg2 = (m1+m2)/2.0;
		//System.out.println(avg1/20.0+"  "+avg2);
		
		double tempo = 90.0;
		
		Map<Pilota, Double> mappa = new HashMap<>();
		
		for(Pilota p : model.getAllPiloti()){
			double e2 = t.CalcolaPrestazioneScuderia(p.getS())*0.71+p.getOvr()/100.0*0.29;
			double e3 = Math.round(e2*1000)/1000.0;
			double e = tempo*(1-(e3-avg2)/4.2);
			mappa.put(p, e);
			System.out.println(p.getCognome()+":   "+(e-88.01244906750385));
		}
		
		double media = tempo;
        double varianza = 0.02;
        double deviazioneStandard = Math.sqrt(varianza);

        NormalDistribution distribuzioneNormale = new NormalDistribution(media, deviazioneStandard);
		double dd = distribuzioneNormale.sample();

	}

}
