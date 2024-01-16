package it.polito.tdp.SimulazioneF1.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import it.polito.tdp.SimulazioneF1.db.F1DAO;
import it.polito.tdp.SimulazioneF1.model.Comparator1;
import it.polito.tdp.SimulazioneF1.model.Scuderia;
import org.apache.commons.math3.distribution.NormalDistribution;

public class IndiciCircuiti {
	
	final static String RESET = "\u001B[0m";
    final static String RED = "\u001B[31m";
    final static String GREEN = "\u001B[32m";
    final static String BLUE = "\u001B[34m";
	
	public static void main(String[] args) {

	double q1 = 0.360; double q2 = 0.305; double q3 = 0.490; double q4 = 0.155; double q5 = 0.125; double q6 = 0.185;
	//double q1 = 0.8; double q2 = 0; double q3 = 0.2; double q4 = 0; double q5 = 0; double q6 = 0;
	
	F1DAO dao = new F1DAO();
	
	HashMap<Scuderia, Double> mappa = new HashMap<>();

	for(Scuderia s : dao.getAllScuderia().values()) {
		double r = s.getAerI()*q1+s.getChaI()*q2+s.getEngI()*q3+q4*s.getAerI()*s.getChaI()+q5*s.getAerI()*s.getEngI()+q6*s.getEngI()*s.getChaI();
		r = Math.round(r*1000);
		mappa.put(s, r);
	}
	
	ArrayList<Entry<Scuderia,Double>> lista = new ArrayList<>(mappa.entrySet());
	
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
	
	

	}

}
