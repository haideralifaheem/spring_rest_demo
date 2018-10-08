package com.spring.demo.movies.services;

import java.util.List;

import com.spring.demo.movies.model.Actor;
import com.spring.demo.movies.repository.ActorRepository;
import com.spring.demo.movies.services.interfaces.IActorService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService implements IActorService {

    private static final Logger LOGGER = LogManager.getLogger(ActorService.class);

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor findByActorId(String id) {
        LOGGER.info("Finding a Actor by ID");

        return actorRepository.findByActorId(id);
    }

    @Override
    public List<Actor> findAll() {
        LOGGER.info("Finding a Actor by ID");

        return actorRepository.findAll();
    }

    @Override
    public List<Actor> findbyFirstName(String name) {
        LOGGER.info("Finding a Actor by First Name");

        return actorRepository.findByfirstName(name);
    }

}
