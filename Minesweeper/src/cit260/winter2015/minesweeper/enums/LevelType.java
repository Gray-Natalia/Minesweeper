/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.enums;

import cit260.winter2015.minesweeper.GameVariables;

/**
 *
 * @author cheryl
 */
public enum LevelType {

    BEGINNER("beginner", 9, 9, 10), INTERMEDIATE("intermediate", 16, 16, 40), EXPERT("expert", 16, 30, 99);
    private final String difficulty;
    private final int rows;
    private final int columns;
    private final int mines;
    public static int CELL_SIZE = 30;
    public static int NUM_IMAGES = 16;

    LevelType(String difficulty, int rows, int columns, int mines) {
        this.difficulty = difficulty;
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
    }

    public String getDifficulty() {
        return difficulty;
    }
    
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }
    
    public static void setBeginner() {
        GameVariables.setGameVariables(BEGINNER.getDifficulty(), BEGINNER.getRows(), BEGINNER.getColumns(), BEGINNER.getMines());
    }
    
    public static void setIntermediate() {
        GameVariables.setGameVariables(INTERMEDIATE.getDifficulty(), INTERMEDIATE.getRows(), INTERMEDIATE.getColumns(), INTERMEDIATE.getMines());
    }
    
    public static void setExpert() {
        GameVariables.setGameVariables(EXPERT.getDifficulty(), EXPERT.getRows(), EXPERT.getColumns(), EXPERT.getMines());
    }
}
