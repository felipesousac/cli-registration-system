package com.projeto.utils;

import com.projeto.exceptions.InvalidEmailException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FindByEmail {

    public static void find(String email) throws InvalidEmailException {
        File dir = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\users");
        File[] dirList = dir.listFiles();

        if (dirList != null) {
            for (File file: dirList) {

                try (FileReader fr = new FileReader(file);
                     BufferedReader br = new BufferedReader(fr)) {

                    br.readLine();
                    String tmpEmail = br.readLine();

                    if (tmpEmail.toLowerCase().equals(email)) {
                        throw new InvalidEmailException("Email already registered");
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
