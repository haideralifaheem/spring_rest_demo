package com.spring.demo.movies.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String movieId;
    @NotNull
    private String title;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    @NotNull
    @DBRef
    private List<Actor> actors;
    @NotNull
    @DBRef
    private List<Director> directors;
    private String genre;

    public Movie() {
    }

    public Movie(String title, String description, String genre, Date releaseDate, List<Actor> actors,
            List<Director> directos) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.directors = directos;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieid) {
        this.movieId = movieid;
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

    public List<Actor> getActors() {
        return actors;
    }

    @Required
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    @Required
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }
}