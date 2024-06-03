package it.polito.tdp.SimulazioneF1.model;
import java.util.*;
import it.polito.tdp.SimulazioneF1.db.F1DAO;

public class Model {
	
	F1DAO dao;
	private HashMap<Integer, Track> circuiti;
	
	int aero;
	int telaio;
	int motore;
	int affid;
	
	public Model() {
		dao = new F1DAO(); 
		circuiti = new HashMap<Integer, Track>(dao.getAllTracks());
		dao.getIndiciSorpasso();
	}
	
	//ogni volta che richiamo lista piloti e scuderia la vado a riprendere dal dao
	public List<Scuderia> getAllScuderie(){
		return new ArrayList<Scuderia>(dao.getScuderie());
	}
	
	public List<Pilota> getAllPiloti(){
		return new ArrayList<Pilota>(dao.getPiloti());
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
	
	public void simula(Scuderia s, int a, int b, int c, int d, Pilota p1, Pilota p2) {
		List<Pilota> piloti = this.getAllPiloti();
		List<Scuderia> scuderie = this.getAllScuderie();
		this.aero = a;
		this.telaio = b;
		this.motore = c;
		this.affid = d;
		
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
    			
			if(p.equals(p1)) {
				p1 = p;
			}else if(p.equals(p2)) {
				p2 = p;
			}
    		
    	}
    	
    	for(Scuderia ss : scuderie) {
    		if(s.equals(ss)) {
    			s = ss;
    		}
    	}
		
		if(p1==null && p2==null) {
			p1=P1;
			p2=P2;
		}else {
			this.Scambio(P1, p1);
			this.Scambio(P2, p2);
		}
		
		Investimento investimento = new Investimento(s, a, b, c, d, this.findMaxOverall(scuderie), this.findMaxDur(scuderie));
		
		Sim sim = new Sim(this, piloti, scuderie);
		sim.init();
		sim.run();
		
		
		
		//System.out.println(sim.printClassificaPiloti());
		System.out.println(sim.printClassificaCostruttori());
		System.out.println(sim.Stats());
		
		sim.loadP(s);
		pilota1 = sim.gets1();
		pilota2 = sim.gets2();
		sim.loadSc(s);
		Sc = sim.getScud();
		
		this.reload();
		
	}
	
	String pilota1;
	String pilota2;
	String Sc;
	
	public int getAero() {
		return aero;
	}

	public int getTelaio() {
		return telaio;
	}

	public int getMotore() {
		return motore;
	}

	public int getAffid() {
		return affid;
	}

	public String getPilota1() {
		return pilota1;
	}

	public String getPilota2() {
		return pilota2;
	}

	public String getSc() {
		return Sc;
	}

	private double findMaxpit(List<Scuderia> scuderie) {
		double max = 0.0;
		
		for(Scuderia s : scuderie) {
			if (s.getDurability()>max) {
				max = s.getDurability();
			}
		}
		
		return max;
	}
	
	private double findMaxDur(List<Scuderia> scuderie) {
		double max = 0.0;
		
		for(Scuderia s : scuderie) {
			if (s.getDurability()>max) {
				max = s.getDurability();
			}
		}
		
		return max;
	}
	
	private void reload() {
		dao.reload();
	}	
		
	private double findMaxOverall(List<Scuderia> scuderie) {
		
		double max = 0.0;
		
		for(Scuderia s : scuderie) {
			if (s.getTotOVR()>max) {
				max = s.getTotOVR();
			}
		}
		
		return max;
	}
	

}
