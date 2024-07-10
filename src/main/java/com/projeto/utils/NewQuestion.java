package com.projeto.utils;

import java.io.*;
import java.util.Scanner;

public class NewQuestion {

    public static void newQuestion() {
        File file = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\formulario.txt");
        int counter = 0;

        try (Scanner scanner = new Scanner(file);) {

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                counter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             ) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter new question: ");
            String question = scanner.nextLine();

            bw.newLine();
            bw.write((counter + 1) + " - " + question);
            System.out.println("---Registered question---");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
