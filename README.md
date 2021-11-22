
# Guided Search Microservice using Dialogflow SDK

The goal of this customizable project is to build an Artificial Intelligence (AI) powered Search bot capability, that leverages Natural Language Understanding (NLU) to provide self-service to end users.

This interacts with the following integration:
Google Cloud SQL (to store back end data that will give the results for search request)
DialogFlow
Play Framework

This project has following component:
1) A web client and a Play application. Dialogflow and cloud sql features are exposed via HTTP by actions (index, availability, db), which are logically grouped within controllers (HomeController.java)

2) HTTP requests performed by the client application are processed by the router (Route) that calls the corresponding action (index in our case) according to URL patterns we configured

3) Actions (index) fill the gap between the HTTP world and Dialogflow. Action “index” maps Dialogflow to an HTTP endpoint

# File conf/routes: </BR>
GET     /search                     controllers.HomeController.index </BR>
GET     /extract                    controllers.HomeController.db </BR>
GET     /availability               controllers.HomeController.availability </BR>

# Please Note
1) When setting up the project in IDE, set the environment variable. GOOGLE_APPLICATION_CREDENTIALS to the path of the service account file.

2) This service account should have proper roles to access to Dialogflow and CloudSQL


# Background Run and Troubleshooting:

Under the project root directory, the build.sbt file describes the project to the build system.

The app/ directory contains the application's source code. It contains a package called controllers with one controller "HomeController.java" and a package called models with connector classes for dialogflow and cloud sql.

The conf/routes file defines the mapping between the HTTP endpoints of the application (URLs) and their corresponding actions. Note that this follows the REST conventions. (http://hostip:portnumber/search?query=userquery&n=sessionid)

Some information is available here for the URL shapes and HTTP verbs:
http://en.wikipedia.org/wiki/REST

# To run this microservice in background:
screen -d -m sbt run &

# To make sure the service is running:
Ps -ef | grep sbt

# To deploy and test the service in a compute layer:
1) Make sure you have sbt and java installed
2) Set the environment variable “GOOGLE_APPLICATION_CREDENTIALS” to path of service account file
3) Clone this repository
4) Navigate to HomeController Class, make sure to update project id with your GCP project id
5) Change Model to point to your dialogflow agent and cloudSQL instance
6) Run “sbt update” to download project dependencies and plugins
7) Run “sbt run” to compile and run the project
8) Microservice will run in the port 9000


## play-java-rest-api-example

A REST API showing Play with a JPA backend.  For the Scala version, please see https://github.com/playframework/play-scala-rest-api-example

## Best Practices for Blocking API

If you look at the controller: https://github.com/playframework/play-java-rest-api-example/blob/master/app/v1/post/PostController.java
then you can see that when calling out to a blocking API like JDBC, you should put it behind an asynchronous boundary -- in practice, this means using the CompletionStage API to make sure that you're not blocking the rendering thread while the database call is going on in the background.


There is more detail in https://www.playframework.com/documentation/latest/ThreadPools -- notably, you can always bump up the number of threads in the rendering thread pool rather than do this -- but it gives you an idea of best practices.
