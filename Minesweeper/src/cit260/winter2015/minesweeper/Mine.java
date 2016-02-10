/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

import java.io.Serializable;

/**
 *
 * @author Keith Banner
 */
public class Mine implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int row;
    private char column;

    public Mine() {
    }

    public Mine(int row, char column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Mine{" + "column=" + column + ", row=" + row + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.row;
        hash = 37 * hash + this.column;
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
        final Mine other = (Mine) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }
}

