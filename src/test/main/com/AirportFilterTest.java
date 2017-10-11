package test.main.com;

import static org.junit.Assert.*;
import org.junit.Test;
import main.com.model.Airport;
import main.com.model.Airports;
import static com.jayway.restassured.RestAssured.*;

public class AirportFilterTest extends FunctionalTest{

    @Test
    public void testAirportsList() {
    	 given().when().get("/airports").then().statusCode(200);
    }

    
    @Test
    public void testGetAirportbyCntryStatusTest() {
    	 given().pathParam("cntry", "LM").when().get("/airports/searchbyCountry/{cntry}").then().statusCode(200);
    }
        

    @Test
    public void testGetAirportbyCodeStatus() {
    	 given().pathParam("code", "CED").when().get("/airports/searchbyCode/{code}").then().statusCode(200);
    }
   
         
    
    @Test
    public void testGetAirportbyCode() {
    	String Code = "CED";
    	 Airport ap = given().pathParam("code", Code).when().get("/airports/searchbyCode/{code}").as(Airport.class);
    	 assertTrue(ap.getCode().equals(Code));
    }
    
    @Test
    public void testGetAirportbyCountryLM() {
    	 Airports ap = given().pathParam("cntry", "LM").when().get("/airports/searchbyCountry/{cntry}").as(Airports.class);    	 
    	 assertTrue(ap.getAirports()==null);
    }
    
    @Test
    public void testGetAirportbyCountryAU() {
    	 Airports ap = given().pathParam("cntry", "AU").when().get("/airports/searchbyCountry/{cntry}").as(Airports.class);    	 
    	 assertFalse(ap.getAirports()==null);
    }
    
    @Test
    public void testGetIntlAirports() {
    	 Airports ap = given().when().get("/airports/intlAirports").as(Airports.class);
    	 if(ap.getAirports()!=null){
    	 for(Airport aps : ap.getAirports())
    	 {
    		  assertTrue(aps.isInternationalAirport());
    	 }
    	 }else{
    		 assertTrue(ap.getAirports()==null);   	 
    	 }
    	 
    }
    
    @Test
    public void testGetregAirports() {
    	 Airports ap = given().when().get("/airports/regAirports").as(Airports.class);
    	 if(ap.getAirports()!=null){
    	 for(Airport aps : ap.getAirports())
    	 {
    		  assertTrue(aps.isRegionalAirport());
    	 }
    	 }
    	 else{
    		 assertTrue(ap.getAirports()==null);   	 
    	 } 	 
    	 
    }
    

   }