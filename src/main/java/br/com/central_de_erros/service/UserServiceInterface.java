package br.com.central_de_erros.service;

import br.com.central_de_erros.model.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> findAll();
}
