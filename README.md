# spring rest demo with Mongodb database
# How to get this project
you could clone the project ,User the develop branch for developmenet and Master branch for release version

```sh
git clone https://github.com/haideralifaheem/spring_rest_demo.git
```

# Movie API

Movie Api is based on spring boot REST application architecture.API main is to provide RESSST end point to add Movies Data into Mongodb DataBase.
Movie object Contain List of Actors and Directors.Actors and Directors are stored in indiviual Mongodb Documents and Added as refrences into Movie Documents.
Rest Api Endpoints are as follows.

```bash
  http://localhost:8888/Movie/findAll
  http://localhost:8888/Movie/{movieId} //Search Movie by Id
  http://localhost:8888/Movie/Title/{Title} //Search Movie by Title
  http://localhost:8888/Movie/findActorbyMovieId/{moveid} //get all actors by Movie ID
  http://localhost:8888/Movie/findDirectorsbyMovieId/{moveid} //get all directos by Movie ID
```
Actor and Director have thier own end points,it is more clean structor and easly extendable.
```bash
  http://localhost:8888/Actor/findAll
  http://localhost:8888/Actor/{actorID} //Search Actor by Id
  http://localhost:8888/Actor/findbyFirstName/{name} //List of Actors by first name
  
  http://localhost:8888/Director/findAll
  http://localhost:8888/Director/{directorID} //Search Director by Id

```
Post method to add new Movie and related data
Actors and Director should not be null
sample movie json is as follow

```json
{
  "title": "Inception",
  "description": "Dom Cobb (Leonardo DiCaprio) is a thief with the rare ability to enter people's dreams and steal their secrets from their subconscious. His skill has made him a hot commodity in the world of corporate espionage but has also cost him everything he loves. Cobb gets a chance at redemption when he is offered a seemingly impossible task: Plant an idea in someone's mind. If he succeeds, it will be the perfect crime, but a dangerous enemy anticipates Cobb's every move.",
  "genre": "Science Fiction",
  "releaseDate": "2010-07-29",
  "directors": [
      {"firstName":"Christopher","lastName":"Nolan","dob":"1970-07-30","gender":"male"}
    ],
  "actors": [
    {"firstName":"Leonardo","lastName":"DiCaprio","dob":"1974-11-11","gender":"male"},
    {"firstName":"Tom","lastName":"Hardy","dob":"1977-09-15","gender":"male"},
    {"firstName":"Ellen","lastName":"page","dob":"1987-02-21","gender":"female"},
    {"firstName":"Joseph","lastName":"Gordon-Levitt","dob":"1981-02-17","gender":"male"},
    {"firstName":"Cillian","lastName":"Murphy","dob":"1976-05-25","gender":"male"},
    {"firstName":"Marion","lastName":"Cotillard","dob":"1975-09-30","gender":"female"},
    {"firstName":"Michael","lastName":"Caine","dob":"1933-03-14","gender":"male"}
  ]
  
}
```
