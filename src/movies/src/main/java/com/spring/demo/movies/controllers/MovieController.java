package com.spring.demo.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.movies.model.Actor;
import com.spring.demo.movies.model.Director;
import com.spring.demo.movies.model.Movie;
import com.spring.demo.movies.services.MovieService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "Movie")
@RestController
@RequestMapping("/Movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@ApiOperation(value = "Find Movie by ID")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{movieid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie get(@PathVariable(value = "movieid") String movieid) {
		Movie movie = movieService.findById(movieid);
		return movie;
	}

	@ApiOperation(value = "Find Movie by Title")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "Title/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie getbyTitle(@PathVariable(value = "title") String title) {
		Movie movie = movieService.findByTitle(title);
		return movie;
	}

	@ApiOperation(value = "Find all Movies")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> findAll() {
		List<Movie> movies = movieService.findAll();
		return movies;
	}

	@ApiOperation(value = "Find Actors by Movie ID")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "findActorsbyMovieId/{movieid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Actor> findActorsbyMovieId(@PathVariable(value = "movieid") String movieid) {
		Movie movie = movieService.findById(movieid);
		return movie.getActors();
	}

	@ApiOperation(value = "Find Directors by Movie ID")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "findDirectorsbyMovieId/{movieid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Director> findDirectorsbyMovieId(@PathVariable(value = "movieid") String movieid) {
		Movie movie = movieService.findById(movieid);
		return movie.getDirectors();
	}

	@ApiOperation(value = "Add a new Movie")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie create(@RequestBody Movie movie) throws Exception {
		Movie createdMovie = movieService.create(movie);
		return createdMovie;
	}

	@ApiOperation(value = "Delete Movie by ID")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "movieId") String movieId) {
		movieService.delete(movieId);
	}
}
