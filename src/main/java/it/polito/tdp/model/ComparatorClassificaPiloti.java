package it.polito.tdp.model;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ComparatorClassificaPiloti implements Comparator<Map.Entry<Pilota, Integer>>{


	@Override
	public int compare(Entry<Pilota, Integer> o1, Entry<Pilota, Integer> o2) {
		return -(o1.getValue().compareTo(o2.getValue()));
	}

	
}
