package it.polito.tdp.SimulazioneF1.model;

public class CalcoloProbabilistico {
	
	public boolean pioggia(Track t) {
    	double i = t.getRainProbability();
    	double p = Math.random();
    	if(p<i) {
    		return true;
    	}else {
    		return false;
    	}
    }
	
	

}
