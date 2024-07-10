package com.projeto.utils;

import com.projeto.entity.User;
import com.projeto.exceptions.InvalidAgeException;
import com.projeto.exceptions.InvalidEmailException;
import com.projeto.exceptions.InvalidHeightException;
import com.projeto.exceptions.InvalidNameException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterUser {

    public static void register() throws InvalidNameException, InvalidEmailException, InvalidAgeException, InvalidHeightException {
        QuestionReader.questions();

        // Count number of lines in form file
        File form = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\formulario.txt");
        int formLines = 0;
        try (FileReader fr = new FileReader(form);
             BufferedReader br = new BufferedReader(fr)) {
            while (br.readLine() != null) {
                formLines++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Scanner scanner = new Scanner(System.in);
        List<String> userInfo = new ArrayList<>();

        System.out.println("==================");

        // Print number identifier of answer
        for (int i = 0; i < formLines; i++) {
            System.out.print((i + 1) + " - ");

            switch (i) {
                case 0:
                    userInfo.add(Validation.isNameValid(scanner.nextLine()));
                    break;
                case 1:
                    userInfo.add(Validation.isEmailValid(scanner.nextLine()));
                    break;
                case 2:
                    userInfo.add(Validation.isAgeValid(scanner.nextLine()));
                    break;
                case 3:
                    userInfo.add(Validation.isHeightValid(scanner.nextLine()));
                    break;
                default:
                    userInfo.add(scanner.nextLine());
            }
        }

        User user = new User(userInfo.get(0), userInfo.get(1), userInfo.get(2), userInfo.get(3));

        System.out.println("---User successfully registered---");
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getAge());
        System.out.println(user.getHeight());
        System.out.println("--------------------");

        File directory = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\users");
        int fileCount = directory.list().length + 1;

        String fileName = fileCount + "-" + user.getName().replace(" ", "").toUpperCase() + ".txt";

        File file = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\users\\" + fileName);
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String data: userInfo) {
                bw.write(data);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
