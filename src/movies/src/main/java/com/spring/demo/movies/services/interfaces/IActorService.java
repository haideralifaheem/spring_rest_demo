package com.spring.demo.movies.services.interfaces;

import java.util.List;

import com.spring.demo.movies.model.Actor;

public interface IActorService {

    Actor findById(final String id);

    List<Actor> findAll();

    void delete(final String id);

}