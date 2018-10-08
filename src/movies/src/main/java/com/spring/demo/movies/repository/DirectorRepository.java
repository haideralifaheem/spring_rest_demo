package com.spring.demo.movies.repository;

import com.spring.demo.movies.model.Director;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirectorRepository extends MongoRepository<Director, String> {
    public Director findByFirstName(String firstName);

    public Director findByDirectorId(String id);
}