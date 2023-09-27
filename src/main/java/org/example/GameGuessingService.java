package org.example;
//интерфейс игры "угадай число"
public interface GameGuessingService {
    int getRandomNumber(int min, int max);

    int getGuessedNumber();

    void checkCorrectGuess(int guessNum, int correctNum);

}
