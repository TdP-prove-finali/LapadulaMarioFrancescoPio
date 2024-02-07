package it.polito.tdp.SimulazioneF1.Test;

import java.util.ArrayList;

import it.polito.tdp.SimulazioneF1.model.*;

public class TestA {

	public static void main(String[] args) {
		
		Model model = new Model();

		/*for(Track t : model.getAllTracks()) {
			
			SimQ x = new SimQ(t, model.getAllPiloti());
			ArrayList<Pilota> grid = new ArrayList<Pilota>(x.getGrid());
			
			SimR y = new SimR(t, model.getAllPiloti(), grid);
			y.run();

		}*/
		
		/*SimQ x = new SimQ(t, model.getAllPiloti());
		ArrayList<Pilota> grid = new ArrayList<Pilota>(x.getGrid());
		
		SimR y = new SimR(t, model.getAllPiloti(), grid);
		y.run();*/
		
	
		Scuderia ss = model.getAllScuderie().get(4);
		Investimento i = new Investimento(ss, 0, 0, 0, 140, 0);
		
		Sim s = new Sim(model, model.getAllPiloti(), model.getAllScuderie());
		s.init();
		s.run();
		System.out.println(s.printClassificaPiloti());
		System.out.println(s.printClassificaCostruttori());
	}

}
