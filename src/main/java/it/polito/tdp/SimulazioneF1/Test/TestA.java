package it.polito.tdp.SimulazioneF1.Test;

import java.util.ArrayList;

import it.polito.tdp.SimulazioneF1.model.*;

public class TestA {

	public static void main(String[] args) {
		
		Model model = new Model();
		Track t = model.getAllTracks().get(5);

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
		
		Sim s = new Sim(model);
		s.init();
		s.run();
		System.out.println(s.printClassificaPiloti());
	
		
		
		
	}

}
