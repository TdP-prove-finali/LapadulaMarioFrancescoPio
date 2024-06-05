package it.polito.tdp.SimulazioneF1.model;

import java.util.*;
import java.util.Map.Entry;

import it.polito.tdp.SimulazioneF1.model.Sessione.evento;

public class Sim {
	
	Model model;
	Queue<Sessione> queue;
	HashMap<Pilota, Integer> classificaPiloti;
	HashMap<Scuderia, Integer> classificaCostruttori;
	ArrayList<Pilota> piloti;
	ArrayList<Scuderia> scuderie;
	
	int Ritiri = 0;
	int Sorpassi = 0;
	int Guasti = 0;
	int Incidenti = 0;
	
	public Sim(Model model, List<Pilota> piloti, List<Scuderia> scuderie) {
		super();
		this.model = model;
		
		this.piloti = new ArrayList<>(piloti);
		this.scuderie = new ArrayList<>(scuderie);
		
		this.classificaPiloti = new HashMap<>();
		this.classificaCostruttori = new HashMap<Scuderia, Integer>();
		queue = new PriorityQueue<>();
	}
	
	public void init() {
		for(Track t : model.getAllTracks()) {
			queue.add(new Sessione(t, evento.QUALIFICA));
			queue.add(new Sessione(t, evento.GARA));
		}
		
		for(Pilota p : this.piloti) {
			this.classificaPiloti.put(p, 0);
		}
		
		for(Scuderia s : this.scuderie) {
			this.classificaCostruttori.put(s, 0);
		}
		
		}
	
	public void run() {
		while(!queue.isEmpty()) {
			process(queue.poll());
		}
		this.riordinaclassifiche();
	}
	
	List<Pilota> grid;
	
	public void process(Sessione s) {
		switch(s.getType()) {
			case QUALIFICA:
				SimQ x = new SimQ(s.getN(), this.piloti);
				grid = new ArrayList<Pilota>(x.getGrid());
				break;
			case GARA:
				SimR y = new SimR(s.getN(), this.piloti, grid);
				y.run();
				LinkedHashMap<Pilota, Integer> result = y.getResult();
				this.loadResult(result);
				this.Ritiri+=y.getRitiro();
				this.Incidenti+=y.getIncidenti();
				this.Guasti+=y.getGuasti();
				this.Sorpassi+=y.getSorpassi();
				break;
		}	
	}
	
	public void loadResult(LinkedHashMap<Pilota, Integer> result) {
		
		for(Pilota p : this.classificaPiloti.keySet()) {
			int posizione = result.get(p);
			Scuderia s = p.getS();
			switch(posizione) {
			case 0:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+25);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+25);
				break;
			case 1:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+18);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+18);
				break;
			case 2:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+15);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+15);
				break;
			case 3:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+12);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+12);
				break;
			case 4:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+10);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+10);
				break;
			case 5:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+8);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+8);
				break;
			case 6:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+6);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+6);
				break;
			case 7:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+4);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+4);
				break;
			case 8:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+2);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+2);
				break;
			case 9:
				this.classificaPiloti.put(p, this.classificaPiloti.get(p)+1);
				this.classificaCostruttori.put(s, this.classificaCostruttori.get(s)+1);
				break;
			}
		}
	}
	
	public void riordinaclassifiche()	{
		this.classificaPiloti = new LinkedHashMap<>(this.riordina(classificaPiloti));
		this.classificaCostruttori = new LinkedHashMap<>(this.riordinaa(classificaCostruttori)); 
	}
	
	public String printClassificaPiloti() {
		
		String s = "";
		int i = 1;
		LinkedHashMap<Pilota, Integer> ordinata = new LinkedHashMap<>(this.riordina(classificaPiloti));
		
		for(Pilota p : ordinata.keySet()) {
			
			s += i+") "+p.getCognome()+" :"+ordinata.get(p)+"\n";
			
			i++;
			
		}
		
		return s;
		
	}

	public String printClassificaCostruttori() {
		
		String s = "";
		int i = 1;
		LinkedHashMap<Scuderia, Integer> ordinata = new LinkedHashMap<>(this.riordinaa(classificaCostruttori));
		
		for(Scuderia ss : ordinata.keySet()) {
			
			s += i+") "+ss.getName()+" :"+ordinata.get(ss)+"\n";
			
			i++;
			
		}
		
		return s;
		
	}
	
	public String Stats() {
		return "Guasti: "+this.Guasti+" Incidenti: "+this.Incidenti+" Sorpassi: "+this.Sorpassi+" Totale: "+this.Ritiri;
	}
	
	private Map<Pilota, Integer> riordina(Map<Pilota, Integer> mappa) {
		
		ArrayList<Entry<Pilota,Integer>> lista = new ArrayList<>(mappa.entrySet());
		
		// Ordina la lista in base ai valori delle chiavi (in ordine decrescente)
	    Collections.sort(lista, new ComparatorClassificaPiloti());

	    // Ricostruisci la mappa ordinata
	    LinkedHashMap<Pilota, Integer> mappaordinata = new LinkedHashMap<>();
	    
	    for (Map.Entry<Pilota, Integer> entry : lista) {
	        mappaordinata.put(entry.getKey(), entry.getValue());
	    }
	    
	    return mappaordinata;
	    
	}

	private Map<Scuderia, Integer> riordinaa(Map<Scuderia, Integer> mappa) {
		
		ArrayList<Entry<Scuderia,Integer>> lista = new ArrayList<>(mappa.entrySet());
		
		// Ordina la lista in base ai valori delle chiavi (in ordine decrescente)
	    Collections.sort(lista, new ComparatorClassificaCostruttori());

	    // Ricostruisci la mappa ordinata
	    LinkedHashMap<Scuderia, Integer> mappaordinata = new LinkedHashMap<>();
	    
	    for (Map.Entry<Scuderia, Integer> entry : lista) {
	        mappaordinata.put(entry.getKey(), entry.getValue());
	    }
	    
	    return mappaordinata;
	    
	}

	String s1;
	String s2;
	String scud;
	
	public void loadP(Scuderia s) {
		String stringa1 = "";
		String stringa2 = "";
		int i = 1;
		boolean flag = false;
		for (Pilota p : this.classificaPiloti.keySet()) {
			if(p.getS().equals(s) && flag==false) {
				stringa1 += i + " " + p.getCognome().substring(0, 3).toUpperCase() + " " + this.classificaPiloti.get(p);
				flag = true;
			}else if(p.getS().equals(s) && flag) {
				stringa2 += i + " " + p.getCognome().substring(0, 3).toUpperCase() + " " + this.classificaPiloti.get(p);
			}
			i++;
		}
		
		s1 = stringa1;
		s2 = stringa2;
	}
	
	public void loadSc(Scuderia s) {
		int i = 1;
		for(Scuderia sc : this.classificaCostruttori.keySet()) {
			if(sc.equals(s)) {
				scud = i + " " + s.getTag() + " " + this.classificaCostruttori.get(sc);
			}
			i++;
		}
	}

	public String gets1() {
		return s1;
	}

	public String gets2() {
		return s2;
	}

	public String getScud() {
		return scud;
	}
	
	
	

	
}