package it.polito.tdp.SimulazioneF1.model;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ComparatorTime implements Comparator<Map.Entry<Pilota, Double>>{

	@Override
	public int compare(Entry<Pilota, Double> o1, Entry<Pilota, Double> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

	
}
