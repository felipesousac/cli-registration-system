package com.projeto.utils;

import com.projeto.exceptions.InvalidAgeException;
import com.projeto.exceptions.InvalidEmailException;
import com.projeto.exceptions.InvalidHeightException;
import com.projeto.exceptions.InvalidNameException;

import java.util.Scanner;

public class Menu {

    public static void mainMenu() throws InvalidNameException, InvalidEmailException, InvalidAgeException, InvalidHeightException {

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 6) {
            System.out.println("""
                    
                    ===MAIN MENU===
                    
                    1 - Register user
                    2 - List all registered users
                    3 - Register new question
                    4 - Delete question
                    5 - Search user by name
                    6 - Finish
                    
                    
                    """);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    RegisterUser.register();
                    break;
                case 2:
                    ListAllUsers.listUser();
                    break;
                case 3:
                    NewQuestion.newQuestion();
                    break;
                case 4:
                    DeleteQuestion.delete();
                    break;
                case 5:
                    FindByName.find();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }


    }
}
