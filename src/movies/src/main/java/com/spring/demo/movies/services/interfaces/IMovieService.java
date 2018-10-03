package com.spring.demo.movies.services.interfaces;

import java.util.List;

import com.spring.demo.movies.model.Movie;

public interface IMovieService {

    Movie create(final Movie movie);

    Movie findById(final String id);

    Movie findByTitle(final String id);

    List<Movie> findAll();

    void delete(final String id);

}