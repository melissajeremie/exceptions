package com.ga.superhero;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class SuperHero {
    public static void main(String args[]) {

        String file = ("/Users/mkj/Desktop/MYAMEX/Homework/week04/02-Tuesday/homework12-week4-exceptions/SuperHeroes/input.txt");
        ArrayList<String> superhero = new ArrayList<>();

        try {
            FileReader inputFile = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(inputFile);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                superhero.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        int score = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < superhero.size(); i++) {
            score += getResult(superhero.get(i), input);
        }
        System.out.println("Your score is " + score);
        if (score > 2) {
            try {
            FileWriter triviaWinner = new FileWriter("/Users/mkj/Desktop/MYAMEX/Homework/week04/02-Tuesday/homework12-week4-exceptions/SuperHeroes/src/output.txt");
            triviaWinner.write("Congrats, " + System.getProperty("user.name") + ", you won!");
            triviaWinner.close();
                System.out.println("Successfully posted game scores to output.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                FileWriter triviaLoser = triviaLoser = new FileWriter("/Users/mkj/Desktop/MYAMEX/Homework/week04/02-Tuesday/homework12-week4-exceptions/SuperHeroes/src/output.txt");
                triviaLoser.write("Sorry, " + System.getProperty("user.name") + ", you lost.                    Better luck next time!");
                triviaLoser.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Successfully posted game scores to output.txt");
            }


        }
        }


    public static int getResult(String answer, Scanner input) {
        switch (answer) {
            case "Spiderman":
                System.out.println("Which superhero faced the villain Green Goblin?");
                break;
            case "Wonder Woman":
                System.out.println("Which superhero has an unbreakable Lasso of Truth? ");
                break;
            case "Superman":
                System.out.println("Which superhero's real name is Kal-El'? ");
                break;
            case "Batman":
                System.out.println("Which superhero is really just a rich guy with a lot of free time? ");
                break;
        }
        String userAnswer = input.nextLine();
        if (userAnswer.equals(answer)) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println("Incorrect");
            return 0;
        }
    }

}
