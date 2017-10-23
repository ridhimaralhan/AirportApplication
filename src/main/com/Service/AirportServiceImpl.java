package main.com.Service;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.com.model.Airport;
import main.com.model.Airports;
public class AirportServiceImpl {
	public List<Airport> getAllAirports() {
		List<Airport> airports = null;
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpHost target = new HttpHost("www.qantas.com.au");
			HttpHost proxy = new HttpHost("gsw-03-proxy.topl.com.au", 3128, "http");
			RequestConfig config = RequestConfig.custom().setProxy(proxy).setCookieSpec("easy").build();
			HttpGet getRequest = new HttpGet("/api/airports");
			getRequest.setConfig(config);
			getRequest.addHeader("Accept", "application/xml");
			getRequest.addHeader("Accept", "application/vnd.qantas.airports.v1+json");
			HttpResponse response = httpClient.execute(target, getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			String strResponse = EntityUtils.toString(response.getEntity());
			ObjectMapper mapper = new ObjectMapper();
			Airports ap = mapper.readValue(strResponse, Airports.class);
			airports = ap.getAirports();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return airports;
	}

	public Airport getAirportbyCode(String Code) {
		List<Airport> airports = getAllAirports();
		for (Airport ap : airports) {
			if (ap.getCode().equals(Code)) {
				return ap;
			}
		}
		return null;
	}

	public List<Airport> getAirportbyCountry(String Country) {
		List<Airport> airports = getAllAirports();
		List<Airport> myAirports = new ArrayList<Airport>();
		for (Airport ap : airports) {
			if (ap.getCountry().getCode().equals(Country)) {
				myAirports.add(ap);
			}
		}
		return myAirports;
	}

	public List<Airport> getInternationalAirport() {
		List<Airport> airports = getAllAirports();
		List<Airport> intlAp = new ArrayList<Airport>();
		for (Airport ap : airports) {
			if (ap.isInternationalAirport()) {
				intlAp.add(ap);
			}
		}
		return intlAp;
	}

	public List<Airport> getRegionalAirport() {
		List<Airport> airports = getAllAirports();
		List<Airport> regAp = new ArrayList<Airport>();
		for (Airport ap : airports) {
			if (ap.isRegionalAirport()) {
				regAp.add(ap);
			}
		}
		return regAp;
	}

}