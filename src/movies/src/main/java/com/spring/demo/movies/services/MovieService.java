package com.spring.demo.movies.services;

import java.util.ArrayList;
import java.util.List;

import com.spring.demo.movies.model.Actor;
import com.spring.demo.movies.model.Director;
import com.spring.demo.movies.model.Movie;
import com.spring.demo.movies.repository.ActorRepository;
import com.spring.demo.movies.repository.DirectorRepository;
import com.spring.demo.movies.repository.MovieRepository;
import com.spring.demo.movies.services.interfaces.IMovieService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService {

    private static final Logger LOGGER = LogManager.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Movie create(Movie movie) {

        LOGGER.info("Creating a Movie");
        Movie movieDB = movieRepository.findByTitle(movie.getTitle());
        if (movieDB == null) {
            List<Actor> actors = new ArrayList<Actor>();
            List<Director> directors = new ArrayList<Director>();
            for (Actor actor : movie.getActors()) {
                Actor actorDB = actor.findActorInDB();
                if (actorDB == null) {
                    actor = actorRepository.save(actor);

                } else {
                    actor = actorDB;
                }
                actors.add(actor);
            }
            for (Director director : movie.getDirectors()) {
                Director directorDB = director.findDirectorInDB();
                if (directorDB == null) {
                    director = directorRepository.save(director);

                } else {
                    director = directorDB;
                }
                directors.add(director);
            }
            movie.setActors(actors);
            movie.setDirectors(directors);
            return movieRepository.save(movie);
        } else {
            LOGGER.info("Movie Already Exists.");
            return movieDB;
        }
    }

    @Override
    public Movie findById(String movieid) {

        LOGGER.info("Finding a movie by ID");

        return movieRepository.findByMovieId(movieid);
    }

    @Override
    public Movie findByTitle(String title) {

        LOGGER.info("Finding a movie by Title");

        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> findAll() {

        LOGGER.info("Finding all Movies");

        return movieRepository.findAll();
    }

    @Override
    public void delete(String movieid) {

        LOGGER.info("Deleting a person");

        movieRepository.deleteById(movieid);
    }
}
