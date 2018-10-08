package com.spring.demo.movies.repository;

import java.util.List;

import com.spring.demo.movies.model.Actor;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActorRepository extends MongoRepository<Actor, String> {
    public List<Actor> findByfirstName(String firstName);

    public Actor findByActorId(String id);
}