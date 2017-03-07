package main.java;

import java.util.Map;

public class Segmentation {

	private String attributeHeader;
	private String attributeType;
	private Map<String, Double> volumes; //in %
	private Map<String, Double> scores; //in %
	public String getAttributeHeader() {
		return attributeHeader;
	}
	public void setAttributeHeader(String attributeHeader) {
		this.attributeHeader = attributeHeader;
	}
	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	public Map<String, Double> getVolumes() {
		return volumes;
	}
	public void setVolumes(Map<String, Double> volumes) {
		this.volumes = volumes;
	}
	public Map<String, Double> getScores() {
		return scores;
	}
	public void setScores(Map<String, Double> scores) {
		this.scores = scores;
	}
	
	
}
