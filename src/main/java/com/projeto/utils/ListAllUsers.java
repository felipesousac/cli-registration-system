package com.projeto.utils;

import java.io.*;

public class ListAllUsers {

    public static void listUser() {
        File directory = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\users");
        String[] list = directory.list();

        System.out.println("---User list---");
        for (String user : list) {

            File tmpFile = new File(directory, user);

            try (FileReader fr = new FileReader(tmpFile);
                 BufferedReader br = new BufferedReader(fr)) {

                String name = user.charAt(0) + " - " + br.readLine();
                System.out.println(name);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("--------------------");
    }
}
