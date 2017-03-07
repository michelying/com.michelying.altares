package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SegmentAggregator {

	private static final Double MAX_PERCENTAGE_PER_INTERVAL = 0.25;

	private List<Segmentation> segmentations;
	private CSVParser csvParser;

	private Integer scoreColumnNumber; // is the last column of the CSV

	public SegmentAggregator(CSVParser csvParser) {
		this.csvParser = csvParser;
		this.scoreColumnNumber = this.csvParser.getHeaders().size();
	}

	public void computeSegmentations() {

		int j = 1;// test : segmentation with columns nb 2
		
		//Get Sorted map of data for the column
		Map<Integer, Double> columnMap = new HashMap<Integer,Double>();
		Map<Integer, Double> scoreMap = new HashMap<Integer,Double>();
		for (Integer i : this.csvParser.getCompanyData().keySet()){
			columnMap.put(i, Double.valueOf(this.csvParser.getCompanyData().get(i).get(j).toString()));
			scoreMap.put(i, Double.valueOf(this.csvParser.getCompanyData().get(i).get(scoreColumnNumber).toString()));
		}
		System.out.println("RAW DATA MAP");
		for (Integer i : columnMap.keySet())
			System.out.println(i+","+columnMap.get(i));
		columnMap = sortByValue(columnMap);
		System.out.println("SORTED DATA MAP");
		for (Integer i : columnMap.keySet())
			System.out.println(i+","+columnMap.get(i));
		
		
		
		

		// // Compute min and max of this column
		// double columnMin = 0.;//Initialization
		// double columnMax = 0.;//Initialization
		// double columnRange;
		// boolean firstRow = true;
		// for (Integer i : this.csvParser.getCompanyData().keySet()){
		// double columnValue =
		// Double.valueOf(this.csvParser.getCompanyData().get(i).get(j).toString());
		// if (firstRow){
		// firstRow = false;
		// columnMin = columnValue;
		// columnMax = columnValue;
		// } else {
		// if (columnValue < columnMin)
		// columnMin = columnValue;
		// if (columnValue > columnMax)
		// columnMax = columnValue;
		// }
		// }
		// columnRange = columnMax - columnMin;
		//
		// System.out.println("Column Header :"+csvParser.getHeaders().get(j));
		// System.out.println("Column Min : "+columnMin);
		// System.out.println("Column Max : "+columnMax);
		// System.out.println("Column Range : "+columnRange);
		//
		// // Compute Segmentation (volumes and scores) for this column
		// Map<String, Double> volumes = new TreeMap<String,Double>();
		// Map<String, Double> scores = new TreeMap<String,Double>();
		// for (Integer i : this.csvParser.getCompanyData().keySet()){
		// for (int k=0;k<NB_INTERVALS;k++){
		// double lowerBound = (columnMin + k*columnRange/NB_INTERVALS);
		// double upperBound = (columnMin + (k+1)*columnRange/NB_INTERVALS);
		// String key = lowerBound+" to "+upperBound;
		//
		// if (!volumes.containsKey(key)){
		// volumes.put(key, 0.);
		// scores.put(key, 0.);
		// }
		//
		// double columnValue =
		// Double.valueOf(this.csvParser.getCompanyData().get(i).get(j).toString());
		// double scoreValue =
		// Double.valueOf(this.csvParser.getCompanyData().get(scoreColumnNumber).get(j).toString());
		// if ((columnValue >= lowerBound)&&(columnValue < upperBound)){
		// volumes.put(key, volumes.get(key)+1);
		// scores.put(key, scores.get(key)+scoreValue);
		// }
		// }
		// }
		// for (String key : volumes.keySet()){
		// System.out.println(key+" "+volumes.get(key)+" "+scores.get(key));
		// }

	}

	private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	private static List<List<Integer>> getAggregatedList(Map<Integer, Double> columnMap){
		
		List<List<Integer>> aggregatedList = new ArrayList<List<Integer>>(); //List of aggregated companies
		
		int totalNumber = columnMap.size();
		
		List<Integer> firstList = new ArrayList<Integer>();
		for (Integer key : columnMap.keySet())
			firstList.add(key);
		
		boolean allListsSplitted = false;
		while (!allListsSplitted){
			//TODO
		}
		
		
		return aggregatedList;
		
	}

}
