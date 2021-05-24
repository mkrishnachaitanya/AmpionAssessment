AmpionAssessment

    API URL to access/call: https://openweathermap.org

    APPID (API Key to uniquely identify the request from an Authenticated Source): 586214337c85e7920184b60aa32ebee2 [Please do not share this key with unauthorized people].

    Requirement: "Number of days" the weather is predicted to be "Sunny" with "temperatures above 20 degrees" in the "next 5 days" for the city "Sydney".

Pre-requisites:

    Java should be installed on our Windows 10 machine (if we are running this from our local machine).
    Any IDE of our choice should be installed in our machine (Eclipse IDE or IntelliJ).
    Get the APPID by registering your details (by providing your unique email address) in the
    ”https://home.openweathermap.org/api_keys”.
    Download the RestAssured libraries and other necessary libraries.

Notes:

    We are executing/performing these requests using Java as a programming language and using RestAssured libraries for sending and receiving requests and responses, respectively, and other libraries necessary to support this project.

    This is a Maven-based project.

    Dependencies used in this project. Added in the pom.xml file.

    Dependencies to be downloaded from https://mvnrepository.com site.
    a) io.rest-assured ---> Java DSL for easy testing of REST services
    b) org.testng ---> Testing framework for Java
    c) com.googlecode.json-simple ---> A simple Java toolkit for JSON
    d) org.apache.poi --> for poi
    e) org.apache.poi ---> for poi-ooxml

    TestNG for assertions

Limitations of the API Requests being made:

    In the Free subscription of API request, we are able to get only 1 day’s[Current Date's] temperature details for Sydney.
    Performed Assertions to check if the API Response contains the name of the State and also the Country name (that we have given as input).
    Performed validations if the current day's temperature is greater than 20 degrees and the weather type is Sunny.
