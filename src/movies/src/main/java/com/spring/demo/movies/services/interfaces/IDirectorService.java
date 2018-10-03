package com.spring.demo.movies.services.interfaces;

import java.util.List;
import com.spring.demo.movies.model.Director;

public interface IDirectorService {

    Director findById(final String id);

    List<Director> findAll();

    void delete(final String id);

}