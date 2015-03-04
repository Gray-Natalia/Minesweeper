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
 * converted to java bean by C Rubenstein
 */
public class CellValue implements Serializable {
    private char column;
    private int row;
    private int cellValue; //value of 10 means mine.
    public CellValue(char col, int ro, int cv) {
        
        column = col;
        row = ro;
        cellValue = cv;
    }

    public CellValue() {
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

    public int getCellValue() {
        return cellValue;
    }

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.column;
        hash = 47 * hash + this.row;
        hash = 47 * hash + this.cellValue;
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
        final CellValue other = (CellValue) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (this.cellValue != other.cellValue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CellValue{" + "column=" + column + ", row=" + row + ", cellValue=" + cellValue + '}';
    }
    
}
