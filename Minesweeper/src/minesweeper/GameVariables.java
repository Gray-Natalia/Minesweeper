/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author knban_000
 */
public class GameVariables {
//    public String playerName = "Keith";
//    public int numberOfMines = 10;
//    public int numberOfColumns = 9;
//    public int numberOfRows = 9;
//    public int numberOfCells = numberOfColumns * numberOfRows;
//    public String difficultyLevel = "Beginner";
    
    public String playerName;
    public int numberOfColumns;
    public int numberOfRows;
    public int numberOfMines;
    public int numberOfCells;
    public String difficultyLevel;
    
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    
    public void setNumberOfColumns(int columns) {
        this.numberOfColumns = columns;
    }
    
    public void setNumberOfRows(int rows) {
        this.numberOfRows = rows;
    }
    
    public void setNumberOfMines(int mines) {
        this.numberOfMines = mines;
    }
    
    public void setNumberOfCells(int cells) {
        this.numberOfCells = cells;
    }
    
    public void setDifficultyLevel(String difficulty) {
        this.difficultyLevel = difficulty;
    }
    
    public String getPlayerName(String name) {
        return playerName;
    }
    
    public int getNumberOfColumns(int columns) {
        return numberOfColumns;
    }
    
    public int getNumberOfRows(int rows) {
        return numberOfRows;
    }
    
    public int getNumberOfMines(int mines) {
        return numberOfMines;
    }
    
    public int getNumberOfCells(int cells) {
        return numberOfCells;
    }
    
    public String getDifficultyLevel(String difficulty) {
        return difficultyLevel;
    }
    
//    public void SetBoardVariables(String difficulty) {
//        switch(difficulty) {
//            case "Beginner":
//                numberOfMines = 10;
//                numberOfColumns = 9;
//                numberOfRows = 9;
//                break;
//            case "Intermediate":
//                numberOfMines = 40;
//                numberOfColumns = 16;
//                numberOfRows = 16;
//                break;
//            case "Expert":
//                numberOfMines = 99;
//                numberOfColumns = 30;
//                numberOfRows = 16;
//                break;
//            case "Default":
////        }
//        numberOfCells = numberOfColumns * numberOfRows;
//    }
}
