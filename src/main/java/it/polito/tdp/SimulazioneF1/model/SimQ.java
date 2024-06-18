package it.polito.tdp.SimulazioneF1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.math3.distribution.NormalDistribution;

public class SimQ {
	
	Track track;
	List<Pilota> piloti;
	HashMap<Pilota, Double> grid;

	public SimQ(Track n, List<Pilota> allPiloti) {
		track = n;
		piloti = new ArrayList<Pilota>(allPiloti);

		this.MakeGrid();
	}
	
	private void MakeGrid() {
		
		HashMap<Pilota, Double> mappa = new HashMap<>();
		ArrayList<Entry<Pilota,Double>> lista;
		
		for(Pilota p : piloti) {
			Scuderia s = p.getS();
			double PS = Math.round(track.CalcolaPrestazioneScuderia(s)*1000);
			double PP = Math.round(p.getOvr()/100*1000);
			double PT = Math.round((PS*19.5+PP*8.5)/25.0);
			NormalDistribution distribuzioneNormale = new NormalDistribution(0, 0.023);
			mappa.put(p, PT+distribuzioneNormale.sample()*1000);
		}
		
		lista = new ArrayList<>(mappa.entrySet());

		// Ordina la lista in base ai valori delle chiavi (in ordine decrescente)
		
	    Collections.sort(lista, new ComparatorTime());
	    Collections.reverse(lista);
	    
	    
	    
	    // Ricostruisci la mappa ordinata
	    grid = new LinkedHashMap<>();
	    for (Map.Entry<Pilota, Double> entry : lista) {
	        grid.put(entry.getKey(), entry.getValue());
	    }
		
	}
	
	public List<Pilota> getGrid(){
		return new ArrayList<>(grid.keySet());
	}
	
	
		

}
