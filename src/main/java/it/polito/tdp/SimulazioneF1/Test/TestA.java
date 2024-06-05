package it.polito.tdp.SimulazioneF1.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;

import it.polito.tdp.SimulazioneF1.model.*;

public class TestA {

	public static void main(String[] args) {
		
		String s1 = "1 VER 180";
		String[] ss1 = s1.split(" ");
		int pos1 =  Integer.valueOf(ss1[0]);
		String tag1 = ss1[1];
		int punti1 = Integer.valueOf(ss1[2]);
		
		System.out.println(pos1+"-"+tag1+"-"+punti1);
	}

}
