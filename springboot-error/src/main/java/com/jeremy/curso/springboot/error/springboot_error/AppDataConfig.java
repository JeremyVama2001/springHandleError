package com.jeremy.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jeremy.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppDataConfig {

    @Bean
    public List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Jeremy", "Valencia"));
        users.add(new User(2L, "Hector", "De Alba"));
        users.add(new User(3L, "Edith", "Ramirez"));

        return users;
    }
}
