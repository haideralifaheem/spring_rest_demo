package com.spring.demo.movies.services;

import java.util.List;

import com.spring.demo.movies.model.Movie;
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

    @Override
    public Movie create(Movie movie) {

        LOGGER.info("Creating a Movie");
        return movieRepository.save(movie);
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
