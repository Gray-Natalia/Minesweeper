/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.enums;

/**
 *
 * @author cheryl
 */
public enum GameCodes {

    PLAYING(1), NOT_PLAYING(0);
    
    private final int gameStatus;

    GameCodes(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getGameStatus() {
        return gameStatus;
    }
}
