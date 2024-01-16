package it.polito.tdp.SimulazioneF1.Test;
import java.util.*;
import java.util.Map.Entry;

import it.polito.tdp.SimulazioneF1.model.Comparator1;
import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Scuderia;
import it.polito.tdp.SimulazioneF1.model.Track;

public class Test {

	public static void main(String[] args) {
		
		final String RESET = "\u001B[0m";
	    final String RED = "\u001B[31m";
	    final String GREEN = "\u001B[32m";
	    final String BLUE = "\u001B[34m";
	   
		Model model = new Model();
		
		HashMap<Scuderia, Double> mappa;
		ArrayList<Entry<Scuderia,Double>> lista;
		
		for(Track t : model.getAllTracks()) {
			if(t.getAC()!=0) {
				
				mappa = new HashMap<>();
				
				System.out.println("\n"+t.getNome()+"\n");

				for(Scuderia s : model.getAllScuderie()) {
					double r = s.getAerI()*t.getAeroI()+s.getChaI()*t.getChasI()+s.getEngI()*t.getPowerI()+t.getAC()*s.getAerI()*s.getChaI()+t.getAP()*s.getAerI()*s.getEngI()+t.getCP()*s.getEngI()*s.getChaI();
					r = Math.round(r*1000);
					mappa.put(s, r);
				}
				
				lista = new ArrayList<>(mappa.entrySet());
				
				// Ordina la lista in base ai valori delle chiavi (in ordine decrescente)
		        Collections.sort(lista, new Comparator1());

		        // Ricostruisci la mappa ordinata
		        Map<Scuderia, Double> mappaOrdinata = new LinkedHashMap<>();
		        for (Map.Entry<Scuderia, Double> entry : lista) {
		            mappaOrdinata.put(entry.getKey(), entry.getValue());
		        }

		        double k = 0;
		        for (Scuderia s : mappaOrdinata.keySet()) {
		        	double diff = Math.abs(mappaOrdinata.get(s) - k);
		        	if(diff<=3) {//RED
		        		System.out.println(RED +s.getTag()+" - "+mappaOrdinata.get(s)+"   "+Math.round(s.getAerI()*1000)/1000.0+"   "+Math.round(s.getChaI()*1000)/1000.0+"   "+Math.round(s.getEngI()*1000)/1000.0+"  -  "+Math.round(s.getTotOVR()*1000)/1000.0+ RESET);
		        	}else if(diff<=7) {//BLUE
		        		System.out.println(BLUE +s.getTag()+" - "+mappaOrdinata.get(s)+"   "+Math.round(s.getAerI()*1000)/1000.0+"   "+Math.round(s.getChaI()*1000)/1000.0+"   "+Math.round(s.getEngI()*1000)/1000.0+"  -  "+Math.round(s.getTotOVR()*1000)/1000.0+ RESET);
		        	}else if(diff>=35 && k!=0) {//GREEN
		        		System.out.println(GREEN +s.getTag()+" - "+mappaOrdinata.get(s)+"   "+Math.round(s.getAerI()*1000)/1000.0+"   "+Math.round(s.getChaI()*1000)/1000.0+"   "+Math.round(s.getEngI()*1000)/1000.0+"  -  "+Math.round(s.getTotOVR()*1000)/1000.0+ RESET);
		        	}else {
		        		System.out.println(s.getTag()+" - "+mappaOrdinata.get(s)+"   "+Math.round(s.getAerI()*1000)/1000.0+"   "+Math.round(s.getChaI()*1000)/1000.0+"   "+Math.round(s.getEngI()*1000)/1000.0+"  -  "+Math.round(s.getTotOVR()*1000)/1000.0);
		        	}
		        	k = mappaOrdinata.get(s);
		        }
		        
		        for(Pilota p : model.getAllPiloti()) {
		        	double d1 = t.CalcolaPrestazioneScuderia(p.getS());
		        	double d2 = p.getOvr()/100.0;
		        	double d3 = d1*0.71 + d2*0.29;
		        	System.out.println(p.getCognome()+" "+Math.round(d3*1000)/1000.0+"   ("+Math.round(d1*1000)/1000.0+"-"+Math.round(d2*1000)/1000.0+")");
		        }
		        
		        
			}
		}
		
	

	}

}
