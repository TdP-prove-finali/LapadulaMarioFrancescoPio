package it.polito.tdp.SimulazioneF1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.math3.distribution.NormalDistribution;

public class SimR {
	
	final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String BLUE = "\u001B[34m";
    final String YELLOW = "\u001B[33m";
    final String PURPLE = "\u001B[35m";
    final String CYAN = "\u001B[36m";
	
	Track t;
	LinkedHashMap<Pilota, Double> gara;
	ArrayList<Pilota> grid;
	Map<Pilota, Double> PrestazionePiloti;
	
	public SimR(Track t, List<Pilota> lista, List<Pilota> grid) {
		this.t = t;
		this.grid = new ArrayList<>(grid);
		this.gara = new LinkedHashMap<Pilota, Double>();
		for(Pilota p : lista) {
			this.gara.put(p, 0.0);
		}
		this.init();
	}
	
	//variabili provvisorie
	
	int contSorpassiPos = 0;
	int contSorpassiOK = 0;
	int contSorpassiNO = 0;
	int contNO = 0;
	
	public void run() {
		
		System.out.println(t.getNome()+"    "+t.getOverI());
		
		this.partenza();
		
		for(int i = 1; i<t.getNGiri(); i++) {
			this.simulaGiro();
			
			if(i>3) {
				
			this.checksorpassi();
			this.gara = new LinkedHashMap<>(this.riordina(gara));
			
			}
			
			System.out.println("\nLAP "+i);
			this.printMap(gara);
			
		}
		
		
		System.out.println("Numero sorpassi possibili: "+contSorpassiPos+"\nNumero sorpassi riusciti: "+contSorpassiOK+"\nNumero sorpassi non riusciti: "+(contSorpassiPos-contNO-contSorpassiOK)+"\nNumero sorpassi non tentati: "+contNO);
		double perc = (1-((double)(contNO))/(double)(contSorpassiPos));
		System.out.println(perc);
	}
	
	private void checksorpassi() {
		
		double pilotaavanti = 0.0;
		Pilota pa = null;
		//pa è il pilota davanti
		
		for(Pilota p : gara.keySet()) {
			
			//da testare, non so se funziona bene il DNF
			if(this.gara.get(p)!=Double.MAX_VALUE && pilotaavanti!=Double.MAX_VALUE) {
				
				if((gara.get(p)-pilotaavanti)<=1.0) {
				
					contSorpassiPos++;
					
					System.out.println(YELLOW+p.getCognome()+" PROVA IL SORPASSO SU "+pa.getCognome()+RESET);
					if(this.ActionSorpasso(p, pa)) {
						
						contSorpassiOK++;
						
						//se il sorpasso viene completato assegno al pilota dietro il tempo di gara del pilota davanti e li distanzio di 1.1 secondi
						this.gara.put(p, this.gara.put(pa, this.gara.get(p)));
						this.gara.put(p, this.gara.get(p)+1.1);
						
						//pa resta pa
						pilotaavanti = this.gara.get(pa); 
						
						System.out.println(BLUE+"SOPRASSO RIUSCITO!"+RESET);
					}else {
						
						System.out.println(PURPLE+"SOPRASSO NON RIUSCITO!"+RESET);
						if(this.gara.get(p)!=Double.MAX_VALUE) {
							
							this.gara.put(p, this.gara.get(p)+0.5);
							
						}						
						
						pa = p;
						pilotaavanti = this.gara.get(pa);
						
					}
					
				}else {
				
				pa = p;
				pilotaavanti = this.gara.get(pa);
				
				}
			
			}
			
		}
		
	}

	
	//P1 è il pilota che tenta il sorpasso su P2
	private boolean ActionSorpasso(Pilota p1, Pilota p2) {
		
		if(this.TrySorpasso(p1)) {
			
			boolean a1 = (Math.random()<(p1.getAggressivity()*1.5/10000.0));
			boolean a2 = (Math.random()<(p2.getAggressivity()*1.5/10000.0));
			
			if(a1 || a2) {
				
				if(a1) {
					
					this.incidente(p1);
					
				}
				if(a2) {
					
					this.incidente(p2);
				
				}
				
				return false;
				
			}else {
			
				Scuderia s1 = p1.getS();
				Scuderia s2 = p2.getS();
				
				double d1 = (s1.getTotOVR()-s2.getTotOVR())/s1.getTotOVR();
					
				double d2 = (p1.getOvr()-p2.getOvr())/p1.getOvr();
					
				double d3 = (p1.getOvertaking()-p2.getDefending())/p1.getOvertaking();
				
				double media = 0;
			    double varianza = 0.04;
			    double deviazioneStandard = Math.sqrt(varianza);
			
			    NormalDistribution distribuzioneNormale = new NormalDistribution(media, deviazioneStandard);
			    double dd = distribuzioneNormale.sample()*10+1.8;
				
				double a = (d1*0.44+d2*0.41+d3*0.15+dd);
				
				System.out.println(CYAN+p1.getCognome()+"   "+p2.getCognome()+": "+a+RESET);
				
				return a>0;
				
			}
		
		}else {
			
			
			contNO++;
			
			
			return false;
			
		}
		
	}
	
	private boolean TrySorpasso(Pilota p1) {
		
		double overtake = t.getOverI();
		double a1 = p1.getAggressivity()/100.0;
		
		double media = (a1-0.3)/2.5;
        double varianza = 0.01;
        double deviazioneStandard = Math.sqrt(varianza);

        NormalDistribution distribuzioneNormale = new NormalDistribution(media, deviazioneStandard);
        double pp = distribuzioneNormale.sample();
        double pp2 = Math.min(pp, 0.38);
        double pp3 = Math.max(-0.1, pp2);
        
        double index = overtake+pp3;
		System.out.println(CYAN+"TRY :"+index+"   "+p1.getCognome()+RESET);
		
		return Math.random()<index;
		
	}

	private boolean IncidentePilotaGiro(Pilota p) {
		
		double index = (450-p.getAdaptability()-p.getControl()*2-p.getReactions()+p.getAggressivity()/2.25)/100000.0;
		
		return (Math.random()<index);
		
	}

	private boolean Guasto(Pilota p) {
		
		double index = p.getS().getDurability()/200.0;
		
		return (Math.random()<index);
		
	}

	private void partenza() {
		
		for(int i = 0; i<grid.size(); i++) {
			this.gara.put(grid.get(i), i*0.4);
		}
		
		this.gara = new LinkedHashMap<>(this.riordina(gara));
		
		 double media = 0;
         double varianza = 0.045;
         double deviazioneStandard = Math.sqrt(varianza);

         NormalDistribution distribuzioneNormale = new NormalDistribution(media, deviazioneStandard);
         
         for(Pilota p : gara.keySet()) {
     
        	 double start = this.gara.get(p)+Math.abs(distribuzioneNormale.sample());
        	 this.gara.put(p, start);
         
         }
         
         this.gara = new LinkedHashMap<>(this.riordina(gara));
         
	}

	private void init() {
		
		this.PrestazionePiloti = new HashMap<>();
		
		double m1 = 0.0;
		double m2 = Double.MAX_VALUE;
		
		for(Pilota p : grid) {
			double d1 = t.CalcolaPrestazioneScuderia(p.getS());
        	double d2 = p.getOvr()/100.0;
        	double d4 = t.getTryeI()/1000.0*(p.getControl()*0.003+p.getSmoothness()*0.007); //calcolo prestazione pilota relativo acircuito (stress della gomma)
        	double d3 = d1*0.71 + d2*0.29+d4;
        	this.PrestazionePiloti.put(p, d3);
        	if(d3>m1) {
        		m1 = d3;
        	}
        	if(d3 < m2) {
        		m2 = d3;
        	}
		}
		
		double avg = (m1+m2)/2.0;
		
		for(Pilota p : this.PrestazionePiloti.keySet()){
			System.out.println(p.getCognome()+": "+this.PrestazionePiloti.get(p));
			double tempoP = 1-(this.PrestazionePiloti.get(p)-avg)/4.2;
			this.PrestazionePiloti.put(p, tempoP);
		}
		
	}
	
	private void simulaGiro() {
		
		double tempo = t.getTempoMedioGiro();
		
		for(Pilota p : this.PrestazionePiloti.keySet()){

			if(this.Guasto(p) || this.IncidentePilotaGiro(p)) {
				
				this.incidente(p);
				
			}else {
				
	        NormalDistribution distribuzioneNormale = new NormalDistribution(tempo*this.PrestazionePiloti.get(p), Math.sqrt(0.024));
			double x = distribuzioneNormale.sample();
			
			double newrecord = this.gara.get(p) + x;
			this.gara.put(p, newrecord);
			
			}
			
		}
		
	}
	
	//riordina la mappa passata in input e riproduce la classifica di gara
	private Map<Pilota, Double> riordina(Map<Pilota, Double> mappa) {
		
		ArrayList<Entry<Pilota,Double>> lista = new ArrayList<>(mappa.entrySet());
		
		// Ordina la lista in base ai valori delle chiavi (in ordine decrescente)
	    Collections.sort(lista, new CamparatorTime());

	    // Ricostruisci la mappa ordinata
	    LinkedHashMap<Pilota, Double> mappaordinata = new LinkedHashMap<>();
	    
	    for (Map.Entry<Pilota, Double> entry : lista) {
	        mappaordinata.put(entry.getKey(), entry.getValue());
	    }
	    
	    return mappaordinata;
	    
	}

	
	private void incidente(Pilota p) {
		
		if(this.gara.get(p)!=Double.MAX_VALUE) {
		
		this.gara.put(p, Double.MAX_VALUE);
		//System.out.println(RED+"INCIDENTE DI "+p.getCognome()+RESET);
		
		}
		
	}
	
	private void printMap(Map<Pilota, Double> mappa) {
		
		int i = 1;
		
		Iterator<Map.Entry<Pilota, Double>> iterator = mappa.entrySet().iterator();
		double leader = iterator.next().getValue();
		
		for(Pilota p : mappa.keySet()) {
			System.out.println(i+") "+p.getCognome()+"   :"+(mappa.get(p)-leader));
			i++;
		}
		
		System.out.println();
	}
}
