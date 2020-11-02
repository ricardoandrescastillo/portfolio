# portfolio
project for portfolio

just clone the repository and import in your ide open in intellj or import as maven project in eclipse.

or run mvn clean install the war will be generated at /target and run in tomcat server portfolio-0.0.1-SNAPSHOT.war

two urls for get the data and for update the data

http://localhost:8080/data.html?id=1000
http://localhost:8080/profile.html?id=1000

you can import in postman the rest collections 
https://www.getpostman.com/collections/d788f91cdf3a3a5d4cf7

there are 4

get user by id http://localhost:8080/api/v1/user/getid/1000
get user data http://localhost:8080/api/v1/user/getuser/falcao
put update data http://localhost:8080/api/v1/user/update/1000

{
	"description": "Radamel Falcao García Zárate es un futbolista colombiano que juega como delantero en el Galatasaray Sport Kulübü de la Superliga de Turquía.",
	"twitterUserName": "falcao",
	"title": "Falcao Garcia"
}

get twitts per user http://localhost:8080/api/v1/twitter/getwitter/falcao
