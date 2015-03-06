/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author Keith Banner
 */
public class Mine implements Serializable {
    private char column;
    private char row;

    public Mine() {
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Mine{" + "column=" + column + ", row=" + row + '}';
    }
}

