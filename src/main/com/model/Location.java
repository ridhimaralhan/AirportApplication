package main.com.model;

import java.io.Serializable;

public class Location implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	String latitude;
	String longitude;

}
