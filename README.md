# Restful-MedicalCare
# complete spring boot "Micro service" with
This is a sample Java / Maven / Spring Boot (version 1.5.6) application that can be used as a starter for creating a microservice complete with built-in health check, metrics and much more. I hope it helps you.
# How To Run 
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss 
installation is necessary. You run it using the `java -jar` command.

   - Clone this repository
   - Make sure you are using JDK 1.8 and Maven 3.x
   - You can build the project and run the tests by running `mvn clean package`
   - Once successfully built, you can run the service by one of these two methods:

   `        java -jar -Dspring.profiles.active=test target/spring-boot-rest-example-0.5.0.war

or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"`     


# About the service 
The service is patient profile managment system with both doctor and patient  profiles  a . It uses `mysql Jpa hibernate  database`  to store the data. You can also do with a  If your database connection properties work, you can call some REST endpoints defined in com.khoubyari.example.api.rest.hotelController on port 8088. (see below)



## Get information about system health, configurations, etc.
`http://localhost:8088/env`

`http://localhost:8088/health`

`http://localhost:8088/info`

`http://localhost:8088/metrics`


## Create a doctor resource
`POST /doctor/add

Accept: application/json

Content-Type: application/json`

`{
"name" : "Beds R Us",
 "personalID":"454871201",
 "Addess":"new York"
 "faculty ":"",
 "Department":""
}`

## Create a doctor resource
`POST http://localhost:8090/doctor/add
Accept: application/json
Content-Type: application/json`



`{
"name" : "Beds R Us",
 "personalID":"454871201",
 "Addess":"new York"
 "faculty ":"",
 "Department":""
}`

## Retrieve list of doctors 
`GET http://localhost:8088/doctor/doctorID/id
Response: HTTP 200
Content:  list`
 

## Create a patient  resource
`POST http://localhost:8090/patient/add
Accept: application/json
Content-Type: application/json`


`{
"name" : "Beds R Us",
 "personalID":"454871201",
 "Addess":"new York"
 "faculty ":"",
 "Department":""
}`

## Retrieve list of doctors 
`GET http://localhost:8088/patient/doctorID/id
Response: HTTP 200
Content:  list `


