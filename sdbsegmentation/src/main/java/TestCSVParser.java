package main.java;

import java.util.Map;

public class TestCSVParser {

	public static void main(String[] args) {
		CSVParser csvParser = new CSVParser("resources/client-enriched-data.csv");

		Map<Integer, Map<Integer,Object>> companyData = csvParser.getCompanyData();
		for (Integer i : csvParser.getHeaders().keySet())
			System.out.print(csvParser.getHeaders().get(i)+", ");
		System.out.println("");
		for (Integer i : companyData.keySet())
			if (i<3){
				for (Integer j : companyData.get(i).keySet())
					System.out.print(companyData.get(i).get(j)+", ");
				System.out.println("");
			}
		
	}

}
