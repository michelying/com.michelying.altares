package main.java;

public class TestSegmentAggregator {

	public static void main(String[] args) {
		
		CSVParser csvParser = new CSVParser("src/main/resources/client-enriched-data.csv");
		SegmentAggregator segmentAggregator = new SegmentAggregator(csvParser);
		
		segmentAggregator.computeSegmentations();

	}

}
