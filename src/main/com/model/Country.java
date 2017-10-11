package main.com.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String code;
	public String getCode() {
		return code;
	}
	public void setCode(String countryCode) {
		this.code = countryCode;
	}

	String display_name;
	public String getdisplay_name() {
		return display_name;
	}
	public void setdisplay_name(String displayName) {
		this.display_name = displayName;
	}
}
