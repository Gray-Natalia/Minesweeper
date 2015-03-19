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

    BEGINNER(9, 9), INTERMEDIATE(16, 16), EXPERT(16, 30);
    private final int row;
    private final int column;

    Level(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
