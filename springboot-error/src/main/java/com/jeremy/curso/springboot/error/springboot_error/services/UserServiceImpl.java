package com.jeremy.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremy.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        /* Usar el stream no esta permitiendo filtrar, el APIStream es una herramienta util, ya que con el no ocupamos iterar,
        el filter nos ayuda a hcaer la funcion del if de boolean para saber si esta o no
        , esta manera de declarar se uso para entender un poquito mas de como optimizar nuestro codigo, pero esto puede quedar aun mas reducido de la siguiente manera 
        asi nos damos cuenta de las distintas maneras en que podemos realizar estas busquedas*/

        /* Optional<User> user = users.stream().filter( usr -> usr.getId().equals(id)).findFirst();
        return user; */

        return users.stream().filter( usr -> usr.getId().equals(id)).findFirst();

        /* User user = null;

        for(User u : users){
            if(u.getId().equals(id)){
                user = u;
                break;
            }
        }
       return Optional.ofNullable(user); */
    }

}
