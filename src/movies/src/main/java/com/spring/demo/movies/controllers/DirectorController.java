package com.spring.demo.movies.controllers;

import java.util.List;

import com.spring.demo.movies.model.Director;
import com.spring.demo.movies.services.DirectorService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Director")
@RestController
@RequestMapping("/Director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @ApiOperation(value = "Find Director by ID")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{directorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Director get(@PathVariable(value = "directorId") String id) {
        Director director = directorService.findById(id);
        return director;
    }

    @ApiOperation(value = "Find all Directors")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Director> findAll() {
        List<Director> directors = directorService.findAll();
        return directors;
    }
}