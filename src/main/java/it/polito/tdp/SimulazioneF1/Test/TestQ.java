package it.polito.tdp.SimulazioneF1.Test;

import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.SimQ;
import it.polito.tdp.SimulazioneF1.model.Track;

public class TestQ {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		for(Track t : model.getAllTracks()) {
			System.out.println(t.getNome()+" "+t.getOverI()*8.225);
		}
		
		
		/*Track t = model.getAllTracks().get(6);
		HashMap<Pilota, Double> mappa1 = new HashMap<>();
		HashMap<Pilota, Double> mappa2 = new HashMap<>();
		ArrayList<Entry<Pilota,Double>> lista2;
		
		for(Pilota p : model.getAllPiloti()) {
			Scuderia s = p.getS();
			double PS = Math.round(t.CalcolaPrestazioneScuderia(s)*1000);
			double PP = Math.round(p.getOvr()/100*1000);
			double PT = Math.round((PS*19.5+PP*8)/25.0);
			mappa1.put(p, PT);
			NormalDistribution distribuzioneNormale = new NormalDistribution(0, 0.023);
			mappa2.put(p, PT+distribuzioneNormale.sample()*1000);
			
			//System.out.println(p.getCognome()+"[ PT: "+ PT +"  PS: "+ PS + "  PP: "+ PP + " ]");
		}
	
		lista2 = new ArrayList<>(mappa2.entrySet());
	
	    Collections.sort(lista2, new Comparator2());
	    
	    Map<Pilota, Double> mappaOrdinataa = new LinkedHashMap<>();
	    for (Map.Entry<Pilota, Double> entry : lista2) {
	        mappaOrdinataa.put(entry.getKey(), entry.getValue());
	    }
	    
	    System.out.println();
	    
	    int k=1;
	    
	    for(Pilota p : mappaOrdinataa.keySet()) {
	    	System.out.println(k+")  "+p.getCognome()+"  ->"+mappaOrdinataa.get(p)+"      ["+(mappaOrdinataa.get(p)-mappa1.get(p))+"]");
	    	k++;
	    }*/
		
		/*for(Track t : model.getAllTracks()) {
			System.out.println("\n"+t.getNome());
			SimQ sim = new SimQ(t, model.getAllPiloti());
			int k = 1;
			for(Pilota p : sim.getGrid()) {
				System.out.println(k+ ". "+ p.getCognome());
				k++;
			}
		}*/
		
		
	    
	}
	
	
	
	
	
	

}
