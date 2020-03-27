package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.models.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // tells that it is a rest controller
@RequestMapping(path = "/auth")
public class AthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    public @ResponseBody
    Author addNewAuthor(@RequestParam String name,@RequestParam String email,@RequestParam String contactNumber) {
        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setEmail(email);
        newAuthor.setContactNumber(contactNumber);
//        created user is to be saved in DB
//        to do that we are gonna need a repository which will implement crud repo
        authorRepository.save(newAuthor);
        return newAuthor;
    }

    @GetMapping(value = "/")
    public @ResponseBody
    List<Author> getAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
}
