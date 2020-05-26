package com.example.demo.models;

import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository <login, Integer>{
     login findByEmailId(String EmailId);
}
