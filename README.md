# Football League Application

#### Prerequisites
* Java 1.8
* Maven 3.6.3
* Spring Boot 2.2.6

#### Build
###### To build the project
```
mvn clean install
```
###### To run the test cases
```
mvn test
```

#### Summary
```
1. This Spring Boot application demonstrates fetching a football team's overall standing position in the league. This
    application hits https://apifootball.com/ to fetch all the data using an API key.
2. GET http://localhost:8080/footballleague/teamstanding
    The api accepts JSON input.
   {
   	"country_name" : "England",
   	"league_name" : "Premier League",
   	"team_name": "Manchester City"
   }
3. The response in JSON.
   {
       "countryIdName": "41-England",
       "leagueIdName": "149-Premier League",
       "teamIdName": "2653-Manchester City",
       "overall_league_position": "1"
   }
4. All the config parameters are present in resources/application.properties

```