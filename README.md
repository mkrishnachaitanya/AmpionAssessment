# AmpionAssessment
AmpionAssessment

1) API URL to access/call: https://openweathermap.org

2) APPID (API Key to uniquely identify the request from an Authenticated Source): 586214337c85e7920184b60aa32ebee2 [Please do not share this key with unauthorized people].

3) Requirement: "Number of days" the weather is predicted to be "Sunny" with "temperatures above 20 degrees" in the "next 5 days" for the city "Sydney".

Pre-requisites:
1) Java should be installed on our Windows 10 machine (if we are running this from our local machine).
2) Any IDE of our choice should be installed in our machine (Eclipse IDE or IntelliJ).
3) Get the APPID by registering your details (by providing your unique email address) in the  
”https://home.openweathermap.org/api_keys”.
4) Download the RestAssured libraries and other necessary libraries.

Notes:
1) We are executing/performing these requests using Java as a programming language and using RestAssured libraries for sending and receiving requests and responses, respectively, and other libraries necessary to support this project.
2) This is a Maven-based project.
3) Dependencies used in this project. Added in the pom.xml file.

4) Dependencies to be downloaded from https://mvnrepository.com site.
<groupId>
			io.rest-assured
			org.testng
			com.googlecode.json-simple
			org.apache.poi  --> for poi
			org.apache.poi ---> for poi-ooxml
</groupId>
 
5) TestNG for assertions

**Limitations of the API Requests being made:**
1) In the Free subscription of API request, we are able to get only 1 day’s[Current Date's] temperature details for Sydney.
2) Could perform Assertions only if the temperature is greater than 20 degrees and Weather is Sunny or not. 
