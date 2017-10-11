package main.com.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean isInternationalAirport() {
		return internationalAirport;
	}
	public void setInternationalAirport(boolean internationalAirport) {
		this.internationalAirport = internationalAirport;
	}
	public boolean isRegionalAirport() {
		return regionalAirport;
	}
	public void setRegionalAirport(boolean regionalAirport) {
		this.regionalAirport = regionalAirport;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getdisplay_name() {
		return display_name;
	}
	public void setdisplay_name(String displayName) {
		this.display_name = displayName;
	}
	public String getcurrency_code() {
		return currencyCode;
	}
	public void setcurrency_code(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	String code;
	String display_name;
	boolean internationalAirport;
	boolean regionalAirport;
	Location location;
	String currencyCode;
	String timezone;
	Country country;
}