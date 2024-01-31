package it.polito.tdp.SimulazioneF1.Test;
import org.apache.commons.math3.distribution.NormalDistribution;

import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Track;

public class CalcoloProbabilita {

    public static void main(String[] args) {
    	
		final String RESET = "\u001B[0m";
	    final String RED = "\u001B[31m";
	    final String GREEN = "\u001B[32m";
	    final String BLUE = "\u001B[34m";
	    
	    
    	Model model = new Model();
    		
    	
    		
    		
    		for(Pilota p : model.getAllPiloti()) {
    			
    			
	            
    			
    		}
    		
    		double media = 0;
            double varianza = 3;
            double deviazioneStandard = Math.sqrt(varianza);

            double min = 0;
            double max = 2;
            

            NormalDistribution distribuzioneNormale = new NormalDistribution(media, deviazioneStandard);
            

            // Calcolo della probabilità
            double probabilita = distribuzioneNormale.cumulativeProbability(max) - distribuzioneNormale.cumulativeProbability(min);

            System.out.println(varianza+" "+2*probabilita);
    		

            
            for(int i = 0; i<100; i++) {
            	System.out.println((1+distribuzioneNormale.sample()/1000));
            }
            
            
            
    
    	
        
        /*for(int i = 0; i<100; i++) {
        	double d = distribuzioneNormale.sample();
        	if(d<0 && d>=-0.2) {
        		System.out.println(GREEN+d+RESET);
        	}else if(d>0.35) {
        		System.out.println(BLUE+d+RESET);
        	}else if(d<-0.2) {//GREEN
        		System.out.println(RED+d+RESET);
        	}else {
        		System.out.println(d);
        	}
        	
        }*/
        
        
    }
    
    
    
    
}