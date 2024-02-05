package it.polito.tdp.SimulazioneF1.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import it.polito.tdp.SimulazioneF1.model.*;;

public class investito {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		Scuderia s = model.getAllScuderie().get(4);
		Investimento i = new Investimento(s, 40, 40, 0, 40, 0);
		
		System.out.println();
		
		LinkedHashMap<Scuderia, Double> mappa = new LinkedHashMap<>();
		
		for(Scuderia ss : model.getAllScuderie()) {
			mappa.put(ss, ss.getTotOVR());
		}
		
		for(Scuderia ss : riordina(mappa).keySet()) {
			System.out.println(ss.getTag()+" - "+Math.round(ss.getAerI()*1000)/1000.0+"   "+Math.round(ss.getChaI()*1000)/1000.0+"   "+Math.round(ss.getEngI()*1000)/1000.0+"  -  "+Math.round(ss.getTotOVR()*1000)/1000.0);
		}
		
		

	}
	
	private static Map<Scuderia, Double> riordina(Map<Scuderia, Double> mappa) {
		
		ArrayList<Entry<Scuderia,Double>> lista = new ArrayList<>(mappa.entrySet());
		
		// Ordina la lista in base ai valori delle chiavi (in ordine decrescente)
	    Collections.sort(lista, new Comparator1());

	    // Ricostruisci la mappa ordinata
	    LinkedHashMap<Scuderia, Double> mappaordinata = new LinkedHashMap<>();
	    
	    for (Map.Entry<Scuderia, Double> entry : lista) {
	        mappaordinata.put(entry.getKey(), entry.getValue());
	    }
	    
	    return mappaordinata;
	    
	}

}
