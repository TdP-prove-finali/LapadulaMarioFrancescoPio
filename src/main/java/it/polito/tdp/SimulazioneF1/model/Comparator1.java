package it.polito.tdp.SimulazioneF1.model;

import java.util.Comparator;
import java.util.Map;

public class Comparator1 implements Comparator<Map.Entry<Scuderia, Double>>{


	@Override
	 public int compare(Map.Entry<Scuderia, Double> entry1, Map.Entry<Scuderia, Double> entry2) {
        return entry2.getValue().compareTo(entry1.getValue());
    }

}
