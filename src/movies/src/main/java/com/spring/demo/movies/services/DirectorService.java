package com.spring.demo.movies.services;

import java.util.List;

import com.spring.demo.movies.model.Director;
import com.spring.demo.movies.repository.DirectorRepository;
import com.spring.demo.movies.services.interfaces.IDirectorService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService implements IDirectorService {

    private static final Logger LOGGER = LogManager.getLogger(ActorService.class);

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Director findById(String id) {
        LOGGER.info("Finding a Director by ID");
        return directorRepository.findByDirectorId(id);
    }

    @Override
    public List<Director> findAll() {
        LOGGER.info("Finding a All Directors");
        return directorRepository.findAll();
    }

}
