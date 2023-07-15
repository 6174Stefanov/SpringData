package com.softuni.game_store;

import com.softuni.game_store.exceptions.UserNotLoggedInException;
import com.softuni.game_store.exceptions.ValidationException;
import com.softuni.game_store.services.ExecutorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {


    private final ExecutorService executorService;

    public ConsoleRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        String result;
        try {
            result = executorService.execute(command);
        } catch (ValidationException | UserNotLoggedInException ex) {
            result = ex.getMessage();
        }
        System.out.println(result);
    }
}
