package com.example.demo.controllers;

import com.example.demo.models.login;
import com.example.demo.models.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // tells that it is a rest controller
@RequestMapping(path = "/user")
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

    @PostMapping
    public @ResponseBody
    login addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String contactNumber) {
        login newLogin = new login();
        newLogin.setName(name);
        newLogin.setEmail(email);
        newLogin.setContactNumber(contactNumber);
        newLogin.setContactNumber(password);
//        created user is to be saved in DB
//        to do that we are gonna need a repository which will implement crud repo
        loginRepository.save(newLogin);
        return newLogin;
    }

    @GetMapping(value = "/")
    public @ResponseBody
    String getUser(@RequestParam String EmailId, String password) {
        login x = loginRepository.findByEmailId(EmailId);
        if (x != null) {
           if (x.getPassword() == password) {
               return "you can login!!";
           }
           else
               return "password is incorrect";
        }
        return "user does not exist!!";

//        return (List<login>) loginRepository.findAll();
    }
}
