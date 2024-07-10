package com.projeto.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteQuestion {

    public static void delete() {
        File file = new File("C:\\Users\\claud\\OneDrive\\Área de Trabalho\\Projects\\devdojo\\project1\\src\\main\\resources\\formulario.txt");

        List<String> tmpArr = new ArrayList<>();

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                tmpArr.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Deseja apagar qual pergunta? (Selecione o número)");

        for (String question: tmpArr) {
            System.out.println(question);
        }

        Scanner scanner = new Scanner(System.in);
        int questionToRemove = scanner.nextInt();

        if (questionToRemove > 3) {
            tmpArr.remove(questionToRemove - 1);
        } else {
            System.out.println("Essa pergunta não pode ser removida");
        }


        try (FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)) {

            for (int i = 0; i < tmpArr.size(); i++) {
                String question = tmpArr.get(i);
                int position = question.indexOf("-");
                question = question.substring(position);

                bw.write((i + 1) + " " + question);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
