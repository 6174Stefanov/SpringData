package com.softuni.game_store.services.impl;

import com.softuni.game_store.entities.users.LoginDTO;
import com.softuni.game_store.entities.users.RegisterDTO;
import com.softuni.game_store.entities.users.User;
import com.softuni.game_store.services.ExecutorService;
import com.softuni.game_store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExecutorServiceImpl implements ExecutorService {

    private final UserService userService;

    @Autowired
    public ExecutorServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(String commandLine){
        String[] commandParts = commandLine.split("\\|");
        String commandName = commandParts[0];

        String commandOutput = switch (commandName) {
            case REGISTER_USER_COMMAND -> registerUser(commandParts);
            case LOGIN_USER_COMMAND -> loginUser(commandParts);
            case LOGOUT_USER_COMMAND -> logoutUser();
            case ADD_GAME_COMMAND -> addGame();

            default -> "unknown command";
        };
        return commandOutput;
    }

    private String addGame() {
        User loggedUser = this.userService.getLoggedUser();
        if (!loggedUser.isAdmin()){
            //TODO exception for common users;
        }
        return null;
    }

    private String logoutUser() {
        User loggedUser = this.userService.getLoggedUser();

        this.userService.logout();;

        return String.format("User %s successfully logged out.", loggedUser.getFullName());
    }

    private String loginUser(String[] commandParts) {
        LoginDTO loginData = new LoginDTO(commandParts);
        Optional<User> user = userService.login(loginData);

        if (user.isPresent()) {
            return String.format("Successfully logged in %s", user.get().getFullName());
        } else {
            return "Wrong credentials";
        }
    }

    private String registerUser(String[] commandParts) {
        RegisterDTO registerData = new RegisterDTO(commandParts);
        User user = userService.register(registerData);

        return String.format("%s was registered", user.getFullName());
    }
}
