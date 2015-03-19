/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

/**
 *
 * @author cheryl
 */
public enum Level {

    BEGINNER(9, 9, 10), INTERMEDIATE(16, 16, 40), EXPERT(16, 30, 99);
    private final int rows;
    private final int columns;
    private final int mines;

    Level(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
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

    
}
