package com.spring.demo.movies.repository;

import com.spring.demo.movies.model.Actor;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface ActorRepository  extends MongoRepository<Actor, String>{
    public Actor findByFirstName(String firstName);
    public Actor findByIdActor(String id);
}