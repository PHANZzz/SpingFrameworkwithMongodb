package com.crud.java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Users")
public class model {
    @Id
    private int userID;
    private String Username;
    private String address;
    public  model(int userID,String Username,String address){
        this.userID=userID;
        this.Username=Username;
        this.address=address;
    }
    public String getId(int userID){
     return Integer.toString(this.userID);
    }

    public void setUsername(String Username){
        this.Username=Username;
    }
    public void setAddress(String address){
        this.address=address;
    }
}
