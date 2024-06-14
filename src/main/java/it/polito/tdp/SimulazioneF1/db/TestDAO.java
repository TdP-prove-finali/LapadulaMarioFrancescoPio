package it.polito.tdp.SimulazioneF1.db;

import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Scuderia;
import it.polito.tdp.SimulazioneF1.model.Track;

public class TestDAO {

	public static void main(String[] args) {
		
		F1DAO dao = new F1DAO();
		
		for(Scuderia s : dao.getAllScuderia().values()) {
			System.out.println(s.toString());
		}
		for(Pilota p : dao.getAllPiloti().values()) {
			System.out.println(p.toString());
		}
		for(Track t : dao.getAllTracks().values()) {
			System.out.println(t.toString());
		}

	}

}
