package com.openweathermap;

//import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Date;

//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ScheduledData { //This program is written to get the Temperature and WeatherType for the next n(say, 5) number of days.
												// But it could not executed since the free API allows only current day's weather details to be queried. If future date's results are queried, a 401 error is displayed.

	@Test
	public void getScheduledData() throws ParseException
	{
		
		
		//Looping to get a specific number of days(here, 5) details in the request-response.
		for(int i =0; i<5; i++)
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime  now = LocalDateTime.now();
			String date = dtf.format(now.plusDays(i));
			
		
			//1. Setting up the baseURI for the specific number of days(5 days, here).
			//To Specify BaseURI
			
			RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather?q=SYDNEY,au&APPID=a2afe684b03d8f0bdbd6f7c7a9822be4&date=" + date + "";
			//RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather?q=SYDNEY,au&APPID=a2afe684b03d8f0bdbd6f7c7a9822be4";
			System.out.println("http://api.openweathermap.org/data/2.5/weather?q=SYDNEY,au&APPID=a2afe684b03d8f0bdbd6f7c7a9822be4&date=" + date + "");
		}
			
			//2. Creating a Request Specification Object.
			RequestSpecification httpRequest = RestAssured.given();
			
			//3. Creating a Response of the Request.
			Response response = httpRequest.request(Method.GET);
		
			//4) Extract Response Body.
			String responseBody = response.getBody().asString();
			
			//4.1 Printing the response to the console.
			System.out.println("The response body is: " + responseBody);
			
			//5. Asserting to see if the response has the name of the city(here, Sydney) that we have input as part of the request.
			//Assert.assertEquals(responseBody.contains("Sydney"),true);
			//Assert.assertEquals(responseBody.contains("AU"),true);
		
			
		}
	}
//}
