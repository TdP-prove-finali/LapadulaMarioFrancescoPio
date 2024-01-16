package it.polito.tdp.SimulazioneF1.Test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;

import it.polito.tdp.SimulazioneF1.model.Model;
import it.polito.tdp.SimulazioneF1.model.Pilota;
import it.polito.tdp.SimulazioneF1.model.Scuderia;

public class Test1 {

	public static void main(String[] args) {

		Model model = new Model();
		final String RESET = "\u001B[0m";
	    final String RED = "\u001B[31m";
	    final String GREEN = "\u001B[32m";
	    final String BLUE = "\u001B[34m";
		
		List<Pilota> piloti = new ArrayList<>(model.getAllPiloti());
		
		for(Pilota p1 : piloti) {
			for(Pilota p2 : piloti) {
				if(p1.getID()<p2.getID()) {
					Scuderia s1 = p1.getS();
					Scuderia s2 = p2.getS();
				
						
					double d1 = (s1.getTotOVR()-s2.getTotOVR())/s1.getTotOVR();
						
					double d2 = (p1.getOvr()-p2.getOvr())/p1.getOvr();
						
					double d3 = (p1.getOvertaking()-p2.getDefending())/p1.getOvertaking();
					
					double media = 0.11;
			        double varianza = 0.02;
			        double deviazioneStandard = Math.sqrt(varianza);

			        NormalDistribution distribuzioneNormale = new NormalDistribution(media, deviazioneStandard);
					double dd = distribuzioneNormale.sample();
					
					double a = ((((d1+Math.abs(d1)*0.25)*0.8+d2+d3*1.25)*100000)/1000.0);
					double b = ((((d1+Math.abs(d1)*0.25)*0.8+d2+d3*1.25+dd)*100000)/1000.0);
					
					if(a>0 && b<0) {
						System.out.println(BLUE);
					}else if(a<0 & b>0) {
						System.out.println(RED);
					}
					
					System.out.println(p1.getCognome()+"   ->"+p1.getS().getTotOVR()+" -"+p1.getOvr()+ " "+p1.getOvertaking());
					System.out.println(p2.getCognome()+"   ->"+p2.getS().getTotOVR()+" -"+p2.getOvr()+ " "+p2.getDefending());
					
					//System.out.println("d1: "+Math.round(d1*0.8*100000)/1000.0+" d2:"+Math.round(d2*100000)/1000.0+" d3:"+Math.round(d3*100000)/1000.0+"   ="+Math.round((d1*0.8+d2+d3*1.25)*100000)/1000.0);
					
					System.out.println("d1: "+Math.round((d1+Math.abs(d1)*0.25)*0.8*100000)/1000.0+" d2:"+Math.round(d2*100000)/1000.0+" d3:"+Math.round(d3*100000)/1000.0+"   ="+Math.round(a));
					System.out.println("d1: "+Math.round((d1+Math.abs(d1)*0.25)*0.8*100000)/1000.0+" d2:"+Math.round(d2*100000)/1000.0+" d3:"+Math.round(d3*100000)/1000.0+"   ="+Math.round(b));
					System.out.println(RESET+"\n");
				}
			}
		}
	}

}
