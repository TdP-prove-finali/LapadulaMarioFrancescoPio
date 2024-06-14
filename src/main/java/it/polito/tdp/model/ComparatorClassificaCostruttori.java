package it.polito.tdp.model;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ComparatorClassificaCostruttori implements Comparator<Map.Entry<Scuderia, Integer>>{


	@Override
	public int compare(Entry<Scuderia, Integer> o1, Entry<Scuderia, Integer> o2) {
		return -(o1.getValue().compareTo(o2.getValue()));
	}

	
}
