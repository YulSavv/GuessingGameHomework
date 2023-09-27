package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class GameGuessingLogic implements GameGuessingService, Game{

    private final int MIN = 1;
    private final int MAX = 10;

    private Scanner scanner;
    private Random random;
    @Override
    public void start() {
        System.out.println("Привет!\nБудешь угадывать? (да/нет)");
        scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("нет")) {
            System.out.println("(×﹏×)");
            return;
        } else if (!answer.equals("да")) {
            System.out.println("(︶︹︺)\nНепонятно, давай до свидания");
            return;
        }

        System.out.println("(⌒‿⌒)");

        while (true) {
            int randomNumber = getRandomNumber(MIN, MAX);
            System.out.println("Угадай число от " + MIN + " до " + MAX);

            while (true) {
                int guessedNumber = getGuessedNumber();

                if (guessedNumber == randomNumber) {
                    System.out.println("╰(▔∀▔)╯");
                    System.out.println("Будешь угадывать? (да/нет)");
                    scanner = new Scanner(System.in);
                    answer = scanner.nextLine();
                    if (answer.equals("нет")) {
                        System.out.println("(¬_¬ )");
                        return;
                    } else if (!answer.equals("да")) {
                        System.out.println("(︶︹︺)\nНепонятно. Давай, до свидания!");
                        return;
                    }
                    System.out.println("(⌒‿⌒)");
                    break;
                } else {
                    checkCorrectGuess(guessedNumber, randomNumber);
                }
            }
        }
    }


    @Override
    public int getRandomNumber(int min, int max) {
        return random.nextInt(max)+1;
    }

    //проверка правильности ввода данных
    @Override
    public int getGuessedNumber() {
        int number;

        while (true) {
            try {
                number = scanner.nextInt();
                if (number < MIN || number > MAX) {
                    System.out.println("Читать не умеешь?");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Я же просил число! Ладно, попробуй еще раз");
                scanner.nextLine();
            }
        }
        return number;
    }

    // угадывание числа
    @Override
    public void checkCorrectGuess(int guessNum, int correctNum) {
        int difference = Math.abs(guessNum - correctNum);
        if (difference > 5) {
            System.out.println("Холодно");
        } else if (difference > 2) {
            System.out.println("Тепло");
        } else {
            System.out.println("Жгётся!");
        }
    }
}
