//Source url to use: https://home.openweathermap.org
//Source: https://timestamp.online/  [Convert timestamp to date]
/*For every API Testing, we have to follow the given below steps.
	1) Create BASE URI.
	2) Create a Request Object  [Request Object will hold the data].
	3) Create a Response Object [Response Object will hold the data].
	4) Extract Response Body.
	5) Validate Response Body.
*/

package com.openweathermap;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetWeatherDetailsFromOpenWeatherMapForCurrentDate {

	@Test
	public void getWeatherDetails() throws ParseException {
	
		//1) Create BASE URI.
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		
		//2) Create a Request Object  [Request Object will hold the data].
		RequestSpecification httpRequest = RestAssured.given();
		
		//3. Once after the above request is sent, we will get a response. We need to capture this response in an Response Object Variable (response).
		Response response = httpRequest.request(Method.GET, "?q=SYDNEY,au&APPID=a2afe684b03d8f0bdbd6f7c7a9822be4&date='23-05-2021");
		
		//4) Extract Response Body.
		String responseBody = response.getBody().asString();
		
		
		//4.1 Printing the response to the console.
		System.out.println("The response body is: " + responseBody);
		
		//5. Asserting to see if the response has the name of the city(here, Sydney) that we have input as part of the request.
		Assert.assertEquals(responseBody.contains("Sydney"),true);
		Assert.assertEquals(responseBody.contains("AU"),true);
	
		//6. Capturing the 'Date' on which this request is made.
		//If we need to extract individual field values, we can use JSONPath Class.
		JsonPath jsonPath = response.jsonPath();
		int dateInInt = jsonPath.get("dt");
		System.out.println("dateInInt is:" + dateInInt);
		long dateInLong = dateInInt; 
		System.out.println("dateinLong is:" + dateInLong);

		Timestamp timeStamp = new Timestamp(dateInLong);
		Date date = new Date(timeStamp.getTime());
		System.out.println("Date retrieved from the JSON response is: " + date);
		
	
		//7. Capturing the temperature (Temperature is captured in Kelvin). We convert that into degrees for validation purposes.
		jsonPath = response.jsonPath();
		float tempInKelvin = jsonPath.get("main.temp");
		//converting temperature from Kelvin to Degrees Celsius
		float actualTemperatureCaptured = (float) (tempInKelvin - 273.15); //temperature is calculated in degrees. 
		System.out.println("The Current date's temperature that is captured is: "+actualTemperatureCaptured);
	
		//7.1 Capturing the weather Type (Sunny, Rain, Snow, Extreme etc.)
		String actualWeatherType = jsonPath.getString("weather.main");
		System.out.println("The Current date's Weather Type is: "+actualWeatherType);
		
		//validations
		//Checking if the current temperature is greater than 20 degrees.
		if(actualTemperatureCaptured == 20f)
		{
			System.out.println("The current day's temperature is above 20 degrees");
		}
		else
		{
			System.out.println("The current day's temperature is below 20 degrees");
		}
		
		//Checking if the weather is Sunny.
		String expectedWeather = "Sunny";
		if(actualWeatherType == expectedWeather)
		{
			System.out.println("The current day's weather is Cloudy...");
		}
		else
		{
			System.out.println("The current day's weather is NOT Cloudy...");
		}
		
		
		/*
		//8. Performing Assertions to check if the temperature if greater than 20 degrees.
		int expectedTemperature = 20;
		Assert.assertEquals(actualTemperatureCaptured,expectedTemperature,"The current temperature is not above 20 degrees.");
				
		//9. Performing Assertions to check if the weather is Sunny.
		String expectedWeatherType="Sunny";
		Assert.assertEquals(actualWeatherType,expectedWeatherType,"The current Weather Type is not Sunny.");
	*/
	}

	
					
	}
