package com.spring.demo.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.movies.model.Actor;
import com.spring.demo.movies.services.ActorService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "Actor")
@RestController
@RequestMapping("/Actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @ApiOperation(value = "Find Actor by ID")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{actorid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Actor get(@PathVariable(value = "actorid") String actorid) {
        Actor actor = actorService.findByActorId(actorid);
        return actor;
    }

    @ApiOperation(value = "Find all Actors")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Actor> findAll() {
        List<Actor> actors = actorService.findAll();
        return actors;
    }

    @ApiOperation(value = "Find Actors by First Name")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "findbyFirstName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Actor> findActorByName(@PathVariable(value = "name") String name) {
        List<Actor> actors = actorService.findbyFirstName(name);
        return actors;
    }
}