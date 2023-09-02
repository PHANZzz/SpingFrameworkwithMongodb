package com.crud.java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Contact")
public class model {
    @Id
    public int userID=0;
    private String email;
    private String message;
    private String subject;
    public  model(int userID,String email,String message,String subject){
        this.userID=userID;
        this.email=email;
        this.message=message;
        this.subject=subject;
    }
    public String getId(int userID){
     return Integer.toString(this.userID);
    }

    public void setUsername(String email){
        this.email=email;
    }
    public void setAddress(String message){
        this.message=message;
    }
    public void setSubject(String subject){
        this.subject=subject;
    }
}
