/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

/**
 *
 * @author knban_000
 */
public class GameVariables {
    public static Object gameStatus;
    public static String playerName;
    public static String difficultyLevel;
    public static int numberOfRows;
    public static int numberOfColumns;
    public static int numberOfMines;

    public GameVariables() {
    }

    public static void setGameVariables(String diff, int rows, int columns, int mines) {
        GameVariables.difficultyLevel = diff;
        GameVariables.numberOfRows = rows;
        GameVariables.numberOfColumns = columns;
        GameVariables.numberOfMines = mines;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        GameVariables.playerName = playerName;
    }

    public static String getDifficultyLevel() {
        return difficultyLevel;
    }

    public static void setDifficultyLevel(String difficultyLevel) {
        GameVariables.difficultyLevel = difficultyLevel;
    }

    public static int getNumberOfRows() {
        return numberOfRows;
    }

    public static void setNumberOfRows(int numberOfRows) {
        GameVariables.numberOfRows = numberOfRows;
    }

    public static int getNumberOfColumns() {
        return numberOfColumns;
    }

    public static void setNumberOfColumns(int numberOfColumns) {
        GameVariables.numberOfColumns = numberOfColumns;
    }

    public static int getNumberOfMines() {
        return numberOfMines;
    }

    public static void setNumberOfMines(int numberOfMines) {
        GameVariables.numberOfMines = numberOfMines;
    }

    public static Object getGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(Object gameStatus) {
        GameVariables.gameStatus = gameStatus;
    }
    
    
    
    
}

