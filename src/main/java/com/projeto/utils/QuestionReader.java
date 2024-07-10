package com.projeto.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class QuestionReader {

    public static void questions() {
        File file = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\formulario.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
