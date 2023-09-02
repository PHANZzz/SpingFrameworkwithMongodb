package com.crud.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.java.model.model;
import com.crud.java.repository.repo;

@CrossOrigin(origins ="ecommerce-project-beta-swart.vercel.app")

@RestController
public class insert {
    public int ID=0;
    @Autowired
    public repo Repo;

    @PostMapping("/UserPost")
    public void saveUser(@RequestBody model data) {
        ID++;
        data.userID=ID;
        Repo.save(data);
    }

    @GetMapping("/")
    public List<model> getList() {
        return Repo.findAll();
    }


    }
