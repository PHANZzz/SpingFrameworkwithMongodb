package com.crud.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class UserController {
    @Autowired
    public repo Repo;
    @PostMapping("/UserPost")
    public String saveUser(@RequestBody model data){
        Repo.save(data);
        return "Added User with id : " +data.getUserID();
    }
    @GetMapping("/")
    public List<model>getList(){
        return Repo.findAll();
    }
    
    @PutMapping("/UserUpdate/{id}")
    public String updateUser(@PathVariable int id,@RequestBody model updatedUser){
        Optional<model> data = Repo.findById(id);
        if(data.isPresent()){
            updatedUser.setUserID(id);
            Repo.save(updatedUser);
            return "Updated User with id : " + id;
        } else {
            return "User with id : " + id + " not found";
        }
    }
  
    @DeleteMapping("/UserDelete/{id}")
    public String deleteUser(@PathVariable int id) {
        Optional<model> data = Repo.findById(id);
        if (data.isPresent()) {
            Repo.deleteById(id);
            return "Deleted User with id : " + id;
        } else {
            return "User with id : " + id + " not found";
        }
    }
    
}

