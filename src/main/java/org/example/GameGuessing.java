package org.example;

//базовый класс игры "угадай число"
public class GameGuessing {

    private final GameGuessingLogic gameAccess = new GameGuessingLogic();

    public void start () {
        gameAccess.start();
    }

}