package it.polito.tdp.SimulazioneF1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
	
	
	int NPit = 2;
	int stint;
	double PitCrewMax;
	boolean pioggia;
	
	public SimR(Track t, List<Pilota> lista, List<Pilota> grid) {
		this.t = t;
		this.grid = new ArrayList<>(grid);
		this.gara = new LinkedHashMap<Pilota, Double>();
		for(Pilota p : lista) {
			this.gara.put(p, 0.0);
		}
		this.init();
		this.stint = (t.getNGiri()+3)/(NPit+1);
		this.PitCrewMax();
		this.pioggia = this.pioggia();
	}
	
	
	int ritiro = 0;
	int guasti = 0;
	int incidenti = 0;
	int sorpassi = 0;
	
	public int getRitiro() {
		return ritiro;
	}

	public int getGuasti() {
		return guasti;
	}

	public int getIncidenti() {
		return incidenti;
	}

	public int getSorpassi() {
		return sorpassi;
	}

	public void run() {
		
		//System.out.println(t.getNome()+"    "+t.getOverI());
		
		this.partenza();
		
		for(int i = 1; i<=t.getNGiri(); i++) {
			
			if(i%stint==0) {
				this.pitstop();
				this.gara = new LinkedHashMap<>(this.riordina(gara));
			}
			
			this.simulaGiro();
			
			if(i>3) {
				
			this.checksorpassi();
			this.gara = new LinkedHashMap<>(this.riordina(gara));
			
			}
			
			if(i==t.getNGiri()) {
			//this.printMap(gara);
			}
			
		}

	}
	
	private void checksorpassi() {
		
		double pilotaavanti = 0.0;
		Pilota pa = null;
		//pa è il pilota davanti
		
		for(Pilota pd : gara.keySet()) {
			
			if(this.gara.get(pd)!=Double.MAX_VALUE && pilotaavanti!=Double.MAX_VALUE) {
				
				if((gara.get(pd)-pilotaavanti)<=1.0) {

					
					if(this.ActionSorpasso(pd, pa)) {

						
						//se il sorpasso viene completato assegno al pilota dietro il tempo di gara del pilota davanti e li distanzio di 1.1 secondi
						
						this.gara.put(pd, this.gara.get(pa));
						this.gara.put(pa, this.gara.get(pd)+1.0);
						
						//pa resta pa
						pilotaavanti = this.gara.get(pa); 
						
					}else {
						
						if(this.gara.get(pd)!=Double.MAX_VALUE) {
							
							//problema
							this.gara.put(pd, this.gara.get(pa)+0.85);
							
						}						
						
						pa = pd;
						pilotaavanti = this.gara.get(pa);
						
					}
					
				}else {
				
				pa = pd;
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
					
					if(p1.getS().getTag().equals("RBR")) {
						this.sorpassi++;
					}
					this.incidente(p1);
					
				}
				if(a2) {
					
					if(p2.getS().getTag().equals("RBR")) {
						this.sorpassi++;
					}
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
			    double dd = distribuzioneNormale.sample()*10+1.5;
				
				double a = (d1*0.44+d2*0.41+d3*0.15+dd);
				
				return a>0;
				
			}
		
		}else {			
			
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
		
		return Math.random()<index;
		
	}

	private boolean IncidentePilotaGiro(Pilota p) {
		
		double index = (450-p.getAdaptability()*1.1-p.getControl()*2-p.getReactions()*1.1+p.getAggressivity()/2.3)/100000.0;
		
		return (Math.random()<index);
		
	}
	private boolean Guasto(Pilota p) {
		
		
		double index = Math.pow(p.getS().getDurability(), -1)/1184.8;
		
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
        	double d4 = t.getTryeI()/1000.0*(p.getControl()*0.003+p.getSmoothness()*0.007); //calcolo prestazione pilota relativo a circuito (stress della gomma)
        	double d3;
        	
        	if(pioggia) {
        		d3 = d1*0.48 + d2*0.22 + d4*0.5 + p.getAdaptability()*0.0029;
        	}else {
        		d3 = d1*0.71 + d2*0.29+d4;
        	}
        	
        	NormalDistribution distribuzioneNormale = new NormalDistribution(0, 3.5);
        	
        	this.PrestazionePiloti.put(p, d3*(1+distribuzioneNormale.sample()/1000));
        	
        	if(d3>m1) {
        		m1 = d3;
        	}
        	if(d3 < m2) {
        		m2 = d3;
        	}
		}
		
		double avg = (m1+m2)/2.0;
		
		for(Pilota p : this.PrestazionePiloti.keySet()){
			double tempoP = 1-(this.PrestazionePiloti.get(p)-avg)/4.2;
			this.PrestazionePiloti.put(p, tempoP);
		}
		
	}
	
	public Map<Pilota, Double> getPrestazionePiloti() {
		return PrestazionePiloti;
	}

	private void simulaGiro() {
		
		double tempo = t.getTempoMedioGiro();
		
		for(Pilota p : this.PrestazionePiloti.keySet()){
			
			if(this.gara.get(p)!=Double.MAX_VALUE) {

				if(this.Guasto(p)){
					if(p.getS().getTag().equals("RBR")) {
						this.guasti++;
					}
					this.incidente(p);
				
				}else if(this.IncidentePilotaGiro(p)) {
					
					if(p.getS().getTag().equals("RBR")) {
						this.incidenti++;
					}
					this.incidente(p);
					
				}else {
					
		        NormalDistribution distribuzioneNormale = new NormalDistribution(tempo*this.PrestazionePiloti.get(p), 0.16);
				double x = distribuzioneNormale.sample();			
				
				double newrecord = this.gara.get(p) + x;
				this.gara.put(p, newrecord);
				
				}
				
			}
			
		}
		
	}
	
	//riordina la mappa passata in input e riproduce la classifica di gara
	public Map<Pilota, Double> riordina(Map<Pilota, Double> mappa) {
		
		ArrayList<Entry<Pilota,Double>> lista = new ArrayList<>(mappa.entrySet());
	    Collections.sort(lista, new CamparatorTime());
	    LinkedHashMap<Pilota, Double> mappaordinata = new LinkedHashMap<>();
	    
	    for (Map.Entry<Pilota, Double> entry : lista) {
	        mappaordinata.put(entry.getKey(), entry.getValue());
	    }
	    
	    return mappaordinata;
	    
	}
	
	private void incidente(Pilota p) {
		
		if(this.gara.get(p)!=Double.MAX_VALUE) {
			
		if(p.getS().getTag().equals("RBR")) {
			this.ritiro++;
		}
		
		this.gara.put(p, Double.MAX_VALUE);
		
		}
		
	}
	
	private boolean pioggia() {	
		
		return Math.random()<t.getRainProbability();
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
	
	private void pitstop() {
		
		for(Pilota p : this.gara.keySet()) {
			
			if(this.gara.get(p)!=Double.MAX_VALUE) {
    			
	            double media = 0;
	            double varianza = ((Math.abs(p.getS().getPitCrewValue()-this.getPitCrewMax()))/0.07)+0.1;
	            double deviazioneStandard = Math.sqrt(varianza);	            

	            NormalDistribution distribuzioneNormale = new NormalDistribution(media, deviazioneStandard);
				
	            double pit = p.getS().getPitTime();
	            double aggiunta = Math.abs(distribuzioneNormale.sample());
	            double pitT = aggiunta + pit + t.getTempoPitLane();
				double newrecord = this.gara.get(p) + pitT;
				this.gara.put(p, newrecord);
				
			}
			
		}
		
	}
	
	private void PitCrewMax() {
		
		this.PitCrewMax = 0;
		
		for(Pilota p : this.gara.keySet()) {
			if(p.getS().getPitCrewValue()>this.PitCrewMax) {
				this.PitCrewMax = p.getS().getPitCrewValue();
			}
		}
	}

	public int getStint() {
		return stint;
	}

	public double getPitCrewMax() {
		return PitCrewMax;
	}

	public LinkedHashMap<Pilota, Integer> getResult() {
		
		LinkedHashMap<Pilota, Integer> posizioni = new LinkedHashMap<>();
		
		int i = 0;
		
		for(Pilota p : this.gara.keySet()) {
			
			posizioni.put(p, i);
			i++;
			
		}
		
		return posizioni;
		
	}

	
}
