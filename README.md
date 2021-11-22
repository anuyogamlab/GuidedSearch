<<<<<<< HEAD
# guidedsearch
Guided Search Microservice using Play Framework and Dialogflow
=======
# Search Bot Microservice using Dialogflow SDK

The goal of this project is to build an Artificial Intelligence (AI) powered Search bot capability, that leverages Natural Language Understanding (NLU) to provide self-service to end users (typically consumers).

This has integrated several technologies:

Google Cloud SQL (to store back end data that will give the results for search request)
DialogFlow
Play Framework

# play-java-rest-api-example

A REST API showing Play with a JPA backend.  For the Scala version, please see https://github.com/playframework/play-scala-rest-api-example

## Best Practices for Blocking API

If you look at the controller: https://github.com/playframework/play-java-rest-api-example/blob/master/app/v1/post/PostController.java
then you can see that when calling out to a blocking API like JDBC, you should put it behind an asynchronous boundary -- in practice, this means using the CompletionStage API to make sure that you're not blocking the rendering thread while the database call is going on in the background.


There is more detail in https://www.playframework.com/documentation/latest/ThreadPools -- notably, you can always bump up the number of threads in the rendering thread pool rather than do this -- but it gives you an idea of best practices.
>>>>>>> first commit