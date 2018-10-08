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

@Document(collection = "Directors")
public class Director implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String directorId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String gender;

    public Director() {

    }

    public Director(String firstName, String lastName, Date dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
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

    public Director findDirectorInDB() {
        try {
            Query query = new Query();
            Criteria criteriaDefinition = Criteria.where("firstName").is(this.firstName).and("lastName")
                    .is(this.lastName).and("dob").is(this.dob);
            query.addCriteria(criteriaDefinition);
            List<Director> directors = Application.mongoTamplate.find(query, Director.class);

            if (directors != null && directors.size() > 0) {
                return directors.get(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}