package com.example.demo.models;


import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data @Entity
// @data is for lombok
// @Entity is for java persistence. It will make a table in database.

public class Author extends AuditModel{
    @Id //it makes id as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //Auto assign id values
    Integer id;
    @NotNull// to make it notnull
    String name;
    @NotNull
    @Column(unique = true)//makes email unique
    String email;
    @NotNull
    String contactNumber;
//    lombok would be used to get getter and setter
}
