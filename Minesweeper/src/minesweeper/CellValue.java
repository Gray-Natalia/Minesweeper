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

// constructor used by CellNumberCalculator
public class CellValue {
    public char column;
    public int row;
    public int cellValue; //value of 10 means mine.
    public CellValue(char col, int ro, int cv) {
        
        column = col;
        row = ro;
        cellValue = cv;
    }
}
