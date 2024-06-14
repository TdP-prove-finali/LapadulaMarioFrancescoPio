package it.polito.tdp.model;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ComparatorTime implements Comparator<Map.Entry<Pilota, Double>>{

	@Override
	public int compare(Map.Entry<Pilota, Double> o1, Map.Entry<Pilota, Double> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

	
}
