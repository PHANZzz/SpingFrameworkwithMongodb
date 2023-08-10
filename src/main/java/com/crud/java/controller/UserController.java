package com.crud.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.crud.java.model.model;
import com.crud.java.repository.repo;

@CrossOrigin(origins = "https://crud-spring.vercel.app")

@RestController
public class UserController {
    @Autowired
    public repo Repo;

    @PostMapping("/UserPost")
    public void saveUser(@RequestBody model data) {
        Repo.save(data);
    }

    @GetMapping("/")
    public List<model> getList() {
        return Repo.findAll();
    }

    @PutMapping("/UserUpdate/{id}")
public void updateUser(@PathVariable int id, @RequestBody model updatedUser) {
    Optional<model> data = Repo.findById(id);
    if (data.isPresent()) {
        updatedUser.setUserID(id);
        Repo.save(updatedUser);
    }
}

    @DeleteMapping("/UserDelete/{id}")
    public void deleteUser(@PathVariable int id) {
        Optional<model> data = Repo.findById(id);
        if (data.isPresent()) {
            Repo.deleteById(id);
        } 

    }}
