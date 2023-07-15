package com.softuni.game_store.exceptions;

public class UserNotLoggedInException extends RuntimeException {
    public UserNotLoggedInException(){
        super("Cannot log out. No user was logged in");
    }
}
