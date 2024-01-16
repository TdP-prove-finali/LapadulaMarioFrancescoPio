package it.polito.tdp.SimulazioneF1.model;

import java.util.*;
import it.polito.tdp.SimulazioneF1.model.Sessione.evento;

public class Sim {
	
	Model model;
	Queue<Sessione> queue;
	HashMap<Pilota, Integer> classificaPiloti;
	HashMap<Scuderia, Integer> classificaCostruttori;
	
	List<Sessione> recap; //qui inserisco tutte le sessioni così da poyerle stampare all'occorrenza
	
	public Sim(Model model) {
		super();
		this.model = model;
		this.classificaPiloti = new HashMap<>();
		this.classificaCostruttori = new HashMap<Scuderia, Integer>();
		queue = new PriorityQueue<>();
		recap = new ArrayList<>();
	}

	public void init() {
		for(Track t : model.getAllTracks()) {
			queue.add(new Sessione(t, evento.QUALIFICA));
			queue.add(new Sessione(t, evento.GARA));
		}
		
		for(Pilota p : model.getAllPiloti()) {
			this.classificaPiloti.put(p, 0);
		}
		
		for(Scuderia s : model.getAllScuderie()) {
			this.classificaCostruttori.put(s, 0);
		}
		
		}
	
	public void run() {
		while(!queue.isEmpty()) {
			process(queue.poll());
		}
	}
	
	List<Pilota> grid;
	
	public void process(Sessione s) {
		switch(s.getType()) {
			case QUALIFICA:
				SimQ x = new SimQ(s.getN(), model.getAllPiloti());
				grid = new ArrayList<Pilota>(x.getGrid());
				break;
			case GARA:
				SimR y = new SimR(s.getN(), model.getAllPiloti(), grid);
				HashMap<Pilota, Integer> result = y.getResult();
				this.loadResult(result);
				recap.add(s);
				break;
		}	
	}
	
	//ATTENTO AGLI INDICI DI RISULTATI FINALI
	public void loadResult(HashMap<Pilota, Integer> result) {
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
	
	
}