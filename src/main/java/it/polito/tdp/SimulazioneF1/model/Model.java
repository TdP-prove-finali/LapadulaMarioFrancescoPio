package it.polito.tdp.SimulazioneF1.model;
import java.util.*;
import it.polito.tdp.SimulazioneF1.db.F1DAO;

public class Model {
	
	F1DAO dao;
	//private HashMap<Integer, Scuderia> scuderie;
	//private HashMap<Integer, Pilota> piloti;
	private HashMap<Integer, Track> circuiti;
	
	public Model() {
		dao = new F1DAO(); 
		//scuderie = new HashMap<Integer, Scuderia>(dao.getAllScuderia());
		//piloti = new HashMap<Integer, Pilota>(dao.getAllPiloti());
		circuiti = new HashMap<Integer, Track>(dao.getAllTracks());
		dao.getIndiciSorpasso();
	}
	
	//ogni volta che richiamo lista piloti e scuderia la vado a riprendere dal dao
	public List<Scuderia> getAllScuderie(){
		return new ArrayList<Scuderia>(dao.getAllScuderia().values());
	}
	
	public List<Pilota> getAllPiloti(){
		return new ArrayList<Pilota>(dao.getAllPiloti().values());
	}
	
	public List<Track> getAllTracks(){
		return new ArrayList<Track>(circuiti.values());
	}
	
	public void Scambio(Pilota p, Pilota nuovo) {
		
		if(p.getS().equals(nuovo.getS())) {
			return;
		}else {
			Scuderia ss = nuovo.getS();
			Scuderia s = p.getS();
			
			nuovo.setS(s);
			p.setS(ss);
		}
		
	}
	
	public void simula(Scuderia s, int a, int b, int c, int d, int e, int f, Pilota p1, Pilota p2) {
		List<Pilota> piloti = this.getAllPiloti();
		List<Scuderia> scuderie = this.getAllScuderie();
		
		//forse inutile questa roba dei piloti perchè la faccio già nel controller
		//da verificare
		//bugia, probabilmente è utile
		
		Pilota P1 = null;
		Pilota P2 = null;
		
		int i = 0;
    	
    	for(Pilota p : piloti) {
    		if(p.getS().equals(s)){
    			if(i==0) {
    				P1 = p;
    				i++;
    			}else if(i==1) {
    				P2 = p;
    				i = 0;
    			}
    		}
    	}
		
		if(p1==null && p2==null) {
			p1=P1;
			p2=P2;
		}else {
			this.Scambio(P1, p1);
			this.Scambio(p2, p2);
		}
		
		Investimento investimento = new Investimento(s, a, c, d, e, f);
		Sim sim = new Sim(this, piloti, scuderie);
	}
	

}
