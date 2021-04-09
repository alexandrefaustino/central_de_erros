package br.com.central_de_erros.controller;

import br.com.central_de_erros.model.User;
import br.com.central_de_erros.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInterface service;

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

}
