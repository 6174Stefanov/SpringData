package com.softuni.game_store.services;

import com.softuni.game_store.entities.users.LoginDTO;
import com.softuni.game_store.entities.users.RegisterDTO;
import com.softuni.game_store.entities.users.User;

import java.util.Optional;

public interface UserService {
    User register(RegisterDTO registerData);

    Optional<User> login(LoginDTO loginData);

    User getLoggedUser();

    void logout();
}
