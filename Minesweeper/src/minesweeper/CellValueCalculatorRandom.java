/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Keith
 */
public class CellValueCalculatorRandom {
    public static void main(String args[]) {
        CellValueCalculatorRandom cvc = new CellValueCalculatorRandom();
        cvc.calculateNumMines();
    }
    int numberOfMines = 10;
    int numberOfColumns = 9;
    int numberOfRows = 9;
    int numberOfCells = numberOfColumns * numberOfRows;
    
    CellValueCalculatorRandom[] mineLocation = new CellValueCalculatorRandom[numberOfMines];
    
    CellValue[] cellValueOut = new CellValue[numberOfCells];
    
    public CellValueCalculatorRandom() {  // 9x9 Grid. Column A-I, Row 1-10
        for (int i = 0; i < numberOfMines; i++){
            mineLocation[i] = new CellValueCalculatorRandom((char)('A' + (char) (Math.random() * numberOfColumns)), 1+ (int) (Math.random() * numberOfRows));
            for (int j = 0; j < i; j++){                
                while (mineLocation[i].column == mineLocation[j].column && mineLocation[i].row == mineLocation[j].row) {
                    mineLocation[i] = new CellValueCalculatorRandom((char)('A' + (char) (Math.random() * numberOfColumns)), 1+ (int) (Math.random() * numberOfRows));
                }
            }
        }
    }
    
    public char column;
    public int row;
    public char cellValue;
    public int[] cellValue1;
    
    public CellValueCalculatorRandom(char col, int ro) {
        column = col;
        row = ro;
    }
    
    public void calculateNumMines() {
        CellValueCalculatorRandom cvc = new CellValueCalculatorRandom();
        int j = 0; //Counter for new cellValueBeginner array index.
        for (int r = 1; r <= numberOfRows; r++) {
            for (char c = 'A'; c <= 'A' +numberOfColumns - 1; c++) {
                minefound:   {
                    for (int i = 0; i < numberOfMines; i++) {
                        if (cvc.mineLocation[i].column == c //checks if a mine matches current row
                                && cvc.mineLocation[i].row == r) { //and column.
                            cellValueOut[j] = new CellValue(c, r, 10); //value of 10 means mine.
                            break minefound;
                        }
                    }
                    int tempCellValue = 0;
                    for (int k = 0; k < numberOfMines; k++) { //counter for loop to calculate cell value.

                        //If cell up and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cvc.mineLocation[k].column == (c-1) // Left one column. Skips if first column
                                && r > 0 && cvc.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cvc.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && cvc.mineLocation [k].row == r)
                            tempCellValue++;
                        //If cell down and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cvc.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && r < numberOfRows && cvc.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell directly above current cell is mine, add one to tempCellValue.
                        if (cvc.mineLocation[k].column == c
                                && r > 0 && cvc.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell directly below current cell is mine, add one to tempCellValue.
                        if (cvc.mineLocation[k].column == c
                                && r < numberOfRows && cvc.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell up and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cvc.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r > 0 && cvc.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cvc.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && cvc.mineLocation[k].row == r)
                            tempCellValue++;
                        //If cell down and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cvc.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r < numberOfRows && cvc.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                    }
                    cellValueOut[j] = new CellValue(c, r, tempCellValue);
                }
                j++;
            }
        }
        for(int k1 = 0; k1 < numberOfRows; k1++) { 
            for(int k2 = k1*numberOfRows; k2 < (k1+1)*numberOfRows; k2++) {
                if (cellValueOut[k2].cellValue == 10)
                    System.out.print("M\t");
                else System.out.print(cellValueOut[k2].cellValue + "\t");
            }
            System.out.print("\n");
        }
    }
}
