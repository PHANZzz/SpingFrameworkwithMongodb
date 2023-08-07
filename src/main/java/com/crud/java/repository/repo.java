package com.crud.java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.java.model.model;

public interface  repo extends MongoRepository<model ,Integer> {
    
}
