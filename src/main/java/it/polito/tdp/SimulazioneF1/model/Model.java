package it.polito.tdp.SimulazioneF1.model;
import java.util.*;
import it.polito.tdp.SimulazioneF1.db.F1DAO;

public class Model {
	
	F1DAO dao;
	private HashMap<Integer, Scuderia> scuderie;
	private HashMap<Integer, Pilota> piloti;
	private HashMap<Integer, Track> circuiti;
	
	public Model() {
		dao = new F1DAO(); 
		scuderie = new HashMap<Integer, Scuderia>(dao.getAllScuderia());
		piloti = new HashMap<Integer, Pilota>(dao.getAllPiloti());
		circuiti = new HashMap<Integer, Track>(dao.getAllTracks());
		dao.getIndiciSorpasso();
	}
	
	
	public List<Scuderia> getAllScuderie(){
		return new ArrayList<Scuderia>(scuderie.values());
	}
	
	public List<Pilota> getAllPiloti(){
		return new ArrayList<Pilota>(piloti.values());
	}
	
	public List<Track> getAllTracks(){
		return new ArrayList<Track>(circuiti.values());
	}
	
	
	

}
