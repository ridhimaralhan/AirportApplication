package test.main.com;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class FunctionalTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        String basePath = "/AirportApplication/api/AirportService/";
        RestAssured.basePath = basePath;
        String baseHost = "http://localhost";
        RestAssured.baseURI = baseHost;

    }

}
