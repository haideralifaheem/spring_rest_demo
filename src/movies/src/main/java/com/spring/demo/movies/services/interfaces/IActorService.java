package com.spring.demo.movies.services.interfaces;

import java.util.List;

import com.spring.demo.movies.model.Actor;

public interface IActorService {

    Actor findByActorId(final String id);

    List<Actor> findAll();

    List<Actor> findbyFirstName(final String name);

}