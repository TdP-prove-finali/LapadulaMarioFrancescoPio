package it.polito.tdp.SimulazioneF1.Test;

import it.polito.tdp.SimulazioneF1.model.*;

public class calcoli {

	public static void main(String[] args) {
		
		double d1 = Math.pow((1-0.0018177777777777778)*(1-0.0011834891304347826), 60);
		double d2 = Math.pow(0, 60);
		System.out.println(d1+"-"+d2);
	}

}
