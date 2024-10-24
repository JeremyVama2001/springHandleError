package com.jeremy.curso.springboot.error.springboot_error.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremy.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jeremy.curso.springboot.error.springboot_error.models.domain.User;
import com.jeremy.curso.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService services;

    @GetMapping
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "Ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id){
        User user = services.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe"));
        //Se necesita el ResponseEntity en el nombre de la clase para usuarlo
        /* Optional<User> userOptional = services.findById(id);
        if(userOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        } */

        // return ResponseEntity.ok(userOptional.get());
        return user;
    }
}
