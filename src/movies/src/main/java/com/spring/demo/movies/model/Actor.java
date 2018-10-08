package com.spring.demo.movies.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.demo.movies.Application;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Document(collection = "Actors")
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String actorId;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;

    public Actor() {

    }

    public Actor(String firstName, String lastName, Date dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return dob;
    }

    public void setDOB(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Actor findActorInDB() {
        try {
            Query query = new Query();
            Criteria criteriaDefinition = Criteria.where("firstName").is(this.firstName).and("lastName")
                    .is(this.lastName).and("dob").is(this.dob);

            query.addCriteria(criteriaDefinition);
            List<Actor> actors = Application.mongoTamplate.find(query, Actor.class);

            if (actors != null && actors.size() > 0) {
                return actors.get(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}