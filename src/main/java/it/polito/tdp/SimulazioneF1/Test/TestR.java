package it.polito.tdp.SimulazioneF1.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import it.polito.tdp.SimulazioneF1.model.*;

import org.apache.commons.math3.distribution.NormalDistribution;

import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Track;

public class TestR {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		for(Track tt : model.getAllTracks()) {
			
		SimQ sim = new SimQ(tt, model.getAllPiloti());
		SimR Sim = new SimR(tt, model.getAllPiloti(), sim.getGrid());
		
		
		
	
		
		LinkedHashMap<Pilota, Double> map = new LinkedHashMap<>(Sim.riordina(Sim.getPrestazionePiloti()));
	
		
		int i = 1;
		for(Pilota p : map.keySet()) {
			System.out.println(i+"- "+p.getCognome()+" :"+map.get(p));
			i++;
		}
		
		System.out.println();
		
		

		}
		
	}

}
