/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author knban_000
 * convert to java bean by C Rubenstein
 */
public class ConstructorMineArray implements Serializable {
    private char column;
    private int row;
    
    public ConstructorMineArray(char col, int ro) {
        column = col;
        row = ro;
    }

    public ConstructorMineArray() {
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.column;
        hash = 29 * hash + this.row;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConstructorMineArray other = (ConstructorMineArray) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConstructorMineArray{" + "column=" + column + ", row=" + row + '}';
    }
    
}
