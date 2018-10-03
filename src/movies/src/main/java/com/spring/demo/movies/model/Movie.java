package com.spring.demo.movies.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;

public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String movieid;
    @NotNull
    private String title;
    private String description;
    private Date releaseDate;
    @NotNull
    private Actor[] actors;
    @NotNull
    private Director[] directors;
    private String genre;

    public Movie() {
    }

    public Movie(String title, String description, String genre, Date releaseDate, Actor[] actors,
            Director[] directos) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.directors = directos;
    }

    public String getMovieId() {
        return id;
    }

    public void setMovieId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Actor[] getActors() {
        return actors;
    }

    @Required
    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    public Director[] getDirectors() {
        return directors;
    }

    @Required
    public void setDirectors(Director[] directors) {
        this.directors = directors;
    }
}