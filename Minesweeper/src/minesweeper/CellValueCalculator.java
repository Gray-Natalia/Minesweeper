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
public class CellValueCalculator {
    public static void main(String args[]) {
        CellValueCalculator cvc = new CellValueCalculator();
        cvc.calculateNumMines();
    }
    int numberOfMines = 10;
    int numberOfColumns = 9;
    int numberOfRows = 9;
    int numberOfCells = numberOfColumns * numberOfRows;
    
    CellValueCalculator[] mineLocationBeginner = new CellValueCalculator[numberOfMines];
    
    CellValue[] cellValueBeginner = new CellValue[200];
    
    public CellValueCalculator() {  // 9x9 Grid. Column A-I, Row 1-10
        mineLocationBeginner[0] = new CellValueCalculator('A', 2);
        mineLocationBeginner[1] = new CellValueCalculator('C', 2);
        mineLocationBeginner[2] = new CellValueCalculator('D', 9);
        mineLocationBeginner[3] = new CellValueCalculator('E', 7);
        mineLocationBeginner[4] = new CellValueCalculator('E', 8);
        mineLocationBeginner[5] = new CellValueCalculator('F', 3);
        mineLocationBeginner[6] = new CellValueCalculator('G', 2);
        mineLocationBeginner[7] = new CellValueCalculator('G', 4);
        mineLocationBeginner[8] = new CellValueCalculator('G', 5);
        mineLocationBeginner[9] = new CellValueCalculator('H', 7);
        
    }
    
    public char column;
    public int row;
    public char cellValue;
    public int[] cellValue1;
    
    public CellValueCalculator(char col, int ro) {
        column = col;
        row = ro;
    }
    
    public void calculateNumMines() {
        CellValueCalculator cvc = new CellValueCalculator();
        int j = 0; //Counter for new cellValueBeginner array index.
        for (int r = 1; r <= numberOfRows; r++) {
            for (char c = 'A'; c <= 'A' +numberOfColumns - 1; c++) {
                minefound:   {
                    for (int i = 0; i < numberOfMines; i++) {
                        if (cvc.mineLocationBeginner[i].column == c //checks if a mine matches current row
                                && cvc.mineLocationBeginner[i].row == r) { //and column.
                            cellValueBeginner[j] = new CellValue(c, r, 10); //value of 10 means mine.
                            break minefound;
                        }
                    }
                    int tempCellValue = 0;
                    for (int k = 0; k < numberOfMines; k++) { //counter for loop to calculate cell value.

                        //If cell up and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cvc.mineLocationBeginner[k].column == (c-1) // Left one column. Skips if first column
                                && r > 0 && cvc.mineLocationBeginner[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cvc.mineLocationBeginner[k].column == (c-1) //Left one column. Skips if first column
                                && cvc.mineLocationBeginner [k].row == r)
                            tempCellValue++;
                        //If cell down and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cvc.mineLocationBeginner[k].column == (c-1) //Left one column. Skips if first column
                                && r < numberOfRows && cvc.mineLocationBeginner[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell directly above current cell is mine, add one to tempCellValue.
                        if (cvc.mineLocationBeginner[k].column == c
                                && r > 0 && cvc.mineLocationBeginner[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell directly below current cell is mine, add one to tempCellValue.
                        if (cvc.mineLocationBeginner[k].column == c
                                && r < numberOfRows && cvc.mineLocationBeginner[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell up and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cvc.mineLocationBeginner[k].column == (c+1) //Right one column. Skips if last column
                                && r > 0 && cvc.mineLocationBeginner[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cvc.mineLocationBeginner[k].column == (c+1) //Right one column. Skips if last column
                                && cvc.mineLocationBeginner[k].row == r)
                            tempCellValue++;
                        //If cell down and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cvc.mineLocationBeginner[k].column == (c+1) //Right one column. Skips if last column
                                && r < numberOfRows && cvc.mineLocationBeginner[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                    }
                    cellValueBeginner[j] = new CellValue(c, r, tempCellValue);
                }
                j++;
            }
        }
        for(int k1 = 0; k1 < numberOfRows; k1++) { 
            for(int k2 = k1*numberOfRows; k2 < (k1+1)*numberOfRows; k2++) {
                if (cellValueBeginner[k2].cellValue == 10)
                    System.out.print("M\t");
                else System.out.print(cellValueBeginner[k2].cellValue + "\t");
            }
            System.out.print("\n");
        }
    }
}
