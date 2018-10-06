package com.spring.demo.movies.repository;

import com.spring.demo.movies.model.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
    public Movie findByTitle(String title);

    public Movie findByMovieId(String movieid);
}