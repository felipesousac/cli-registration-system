package com.projeto.utils;

import com.projeto.entity.User;

import java.io.*;
import java.util.Scanner;

public class FindByName {

    public static void find() {
        File dir = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\users");
        File[] dirList = dir.listFiles();

        System.out.println("Enter name to search: ");
        Scanner scanner = new Scanner(System.in);
        String nameToFind = scanner.nextLine().toLowerCase();

        if (dirList != null) {
            for (File file: dirList) {

                try (FileReader fr = new FileReader(file);
                     BufferedReader br = new BufferedReader(fr)) {

                    String name = br.readLine();

                    if (name.toLowerCase().contains(nameToFind)) {
                        String email = br.readLine();
                        String age = br.readLine();
                        String height = br.readLine();

                        User user = new User(name, email, age, height);
                        System.out.println(user);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } else {
            System.out.println("No user found with this name");
        }
    }
}
