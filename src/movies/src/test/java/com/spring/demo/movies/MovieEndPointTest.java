package com.spring.demo.movies;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.demo.movies.model.Actor;
import com.spring.demo.movies.model.Director;
import com.spring.demo.movies.model.Movie;
import com.spring.demo.movies.repository.MovieRepository;
import com.spring.demo.movies.services.MovieService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieEndPointTest {

    final String BASE_PATH = "http://localhost:8888/";

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    private RestTemplate restTemplate;

    private ObjectMapper MAPPER = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        movieRepository.deleteAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Actor> actors = new ArrayList<Actor>();
        Date dob = dateFormat.parse("1974-11-11");
        actors.add(new Actor("Leonardo", "DiCaprio", dob, "male"));

        dob = dateFormat.parse("1977-09-15");
        actors.add(new Actor("Tom", "Hardy", dob, "male"));

        dob = dateFormat.parse("1987-02-21");
        actors.add(new Actor("Ellen", "page", dob, "female"));

        dob = dateFormat.parse("1981-02-17");
        actors.add(new Actor("Joseph", "Gordon-Levitt", dob, "male"));

        dob = dateFormat.parse("1976-05-25");
        actors.add(new Actor("Cillian", "Murphy", dob, "male"));

        dob = dateFormat.parse("1975-09-30");
        actors.add(new Actor("Marion", "Cotillard", dob, "female"));

        dob = dateFormat.parse("1933-03-14");
        actors.add(new Actor("Michael", "Caine", dob, "male"));

        List<Director> directors = new ArrayList<Director>();
        dob = dateFormat.parse("1970-07-30");

        directors.add(new Director("Christopher", "Nolan", dob, "male"));

        Date releaseDate = dateFormat.parse("2010-07-29");
        String desc = "Dom Cobb (Leonardo DiCaprio) is a thief with the rare ability to enter people's dreams and steal their secrets from their subconscious."
                + "His skill has made him a hot commodity in the world of corporate espionage but has also cost him everything he loves. "
                + "Cobb gets a chance at redemption when he is offered a seemingly impossible task: Plant an idea in someone's mind. If he succeeds, it will be the perfect crime, "
                + "but a dangerous enemy anticipates Cobb's every move.";
        movieService.create(new Movie("Inception", desc, "Science Fiction", releaseDate, actors, directors));

        restTemplate = new RestTemplate();
    }

    @Test
    public void testFindAllMovies() throws IOException {
        String response = restTemplate.getForObject(BASE_PATH + "Movie/findAll", String.class);
        List<Movie> movies = MAPPER.readValue(response,
                MAPPER.getTypeFactory().constructCollectionType(List.class, Movie.class));
        Assert.assertNotNull(movies);
        Assert.assertTrue(movies.size() > 0);

    }

    @Test
    public void testActorsByMovieTitle() throws IOException {
        String title = "Inception";
        String response = restTemplate.getForObject(BASE_PATH + "Movie/Title/" + title, String.class);
        Movie movie = MAPPER.readValue(response, Movie.class);
        Assert.assertNotNull(movie);
        Assert.assertNotNull(movie.getActors());
        Assert.assertTrue(movie.getActors().size() > 0);

    }

    @Test
    public void testFindAllActors() throws IOException {
        String response = restTemplate.getForObject(BASE_PATH + "Actor/findAll", String.class);
        List<Actor> actors = MAPPER.readValue(response,
                MAPPER.getTypeFactory().constructCollectionType(List.class, Actor.class));
        Assert.assertNotNull(actors);
        Assert.assertTrue(actors.size() > 0);
        Actor actor = restTemplate.getForObject(BASE_PATH + "Actor/" + actors.get(2).getActorId(), Actor.class);
        Assert.assertNotNull(actor);

    }

    @Test
    public void testFindActorsByFirstName() throws IOException {

        String response = restTemplate.getForObject(BASE_PATH + "Actor/findAll", String.class);
        List<Actor> actors = MAPPER.readValue(response,
                MAPPER.getTypeFactory().constructCollectionType(List.class, Actor.class));
        Assert.assertNotNull(actors);
        Assert.assertTrue(actors.size() > 0);
        response = restTemplate.getForObject(BASE_PATH + "Actor/findbyFirstName/" + actors.get(2).getFirstName(),
                String.class);
        List<Actor> actorsbyName = MAPPER.readValue(response,
                MAPPER.getTypeFactory().constructCollectionType(List.class, Actor.class));
        Assert.assertNotNull(actorsbyName);
        Assert.assertTrue(actorsbyName.size() > 0);
    }

    @Test
    public void testFindAllDirectors() throws IOException {
        String response = restTemplate.getForObject(BASE_PATH + "Director/findAll", String.class);
        List<Director> directors = MAPPER.readValue(response,
                MAPPER.getTypeFactory().constructCollectionType(List.class, Director.class));
        Assert.assertNotNull(directors);
        Assert.assertTrue(directors.size() > 0);

    }

}