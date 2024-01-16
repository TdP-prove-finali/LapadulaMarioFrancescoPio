package it.polito.tdp.SimulazioneF1.model;
import java.util.Comparator;
import java.util.Map;

public class Comparator2 implements Comparator<Map.Entry<Pilota, Double>>{


	@Override
	 public int compare(Map.Entry<Pilota, Double> entry1, Map.Entry<Pilota, Double> entry2) {
        return entry2.getValue().compareTo(entry1.getValue());
    }

}
