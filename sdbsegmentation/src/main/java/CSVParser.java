package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVParser {

	private Map<Integer, String> headers = new HashMap<Integer, String>();
	private Map<Integer, String> headerTypes = new HashMap<Integer, String>();
	private Map<Integer, Map<Integer, Object>> companyData = new HashMap<Integer, Map<Integer, Object>>();

	public CSVParser(String csvFile){
		
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            
            boolean firstLine = true;
            boolean secondLine = true;
            int count = 0;
            
            while ((line = br.readLine()) != null) {

            	String[] columns = line.split(csvSplitBy);
            	
            	if (firstLine){
            		for (int i=0;i<columns.length;i++)
            			headers.put(i, columns[i]);
            		firstLine = false;
            	} else {
            		
            		if (secondLine){
            			for (int i=0;i<columns.length;i++)
                			headerTypes.put(i, columns[i]);
            			secondLine = false;
            		} else {
            			count++;
            			Map<Integer, Object> dataRow = new HashMap<Integer, Object>();
            			
            			for (int i=0;i<columns.length;i++){
            				switch (headerTypes.get(i)){
            				case "enum":
            					dataRow.put(i, columns[i]);
            					break;
            				case "integer":
            					dataRow.put(i, Integer.valueOf(columns[i]));
            					break;
            				case "double":
            					dataRow.put(i, Double.valueOf(columns[i]));
            				}
            			}
            			
            			companyData.put(count, dataRow);
            			
            		}
            	}

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}

	public Map<Integer, String> getHeaders() {
		return headers;
	}

	public Map<Integer, String> getHeaderTypes() {
		return headerTypes;
	}

	public Map<Integer, Map<Integer, Object>> getCompanyData() {
		return companyData;
	}

	
	
}
