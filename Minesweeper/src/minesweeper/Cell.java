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
public class Cell implements Serializable {
    private int row;
    private char column;
    private int value;
    private int state;

    public Cell() {
    }

    public Cell(int row, char column, int value, int state) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.state = state;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.column;
        hash = 11 * hash + this.row;
        hash = 11 * hash + this.value;
        hash = 11 * hash + this.state;
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
        final Cell other = (Cell) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        if (this.state != other.state) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cell{" + "column=" + column + ", row=" + row + ", value=" + value + ", state=" + state + '}';
    }
}
