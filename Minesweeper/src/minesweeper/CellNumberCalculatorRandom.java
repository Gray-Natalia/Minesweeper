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
public class CellNumberCalculatorRandom {
    
    public static void main(String args[]) {
        CellNumberCalculatorRandom cellNumberCalculator = new CellNumberCalculatorRandom();
        cellNumberCalculator.calculateNumMines();
    }
    
    public int numberOfMines = 10;
    public int numberOfColumns = 9;
    public int numberOfRows = 9;
    public int numberOfCells = numberOfColumns * numberOfRows;

    
    CellValue[] cellValueOut = new CellValue[numberOfCells];
    
    public void calculateNumMines() {
        MineLocationsPreset MineLocations = new MineLocationsPreset();
        int j = 0; //Counter for new cellValueBeginner array index.
        for (int r = 1; r <= numberOfRows; r++) {
            for (char c = 'A'; c <= 'A' +numberOfColumns - 1; c++) {
                minefound:   {
                    for (int i = 0; i < numberOfMines; i++) {
                        if (MineLocations.mineLocation[i].column == c //checks if a mine matches current row
                                && MineLocations.mineLocation[i].row == r) { //and column.
                            cellValueOut[j] = new CellValue(c, r, 10); //value of 10 means mine.
                            break minefound;
                        }
                    }
                    int tempCellValue = 0;
                    for (int k = 0; k < numberOfMines; k++) { //counter for loop to calculate cell value.

                        //If cell up and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && MineLocations.mineLocation[k].column == (c-1) // Left one column. Skips if first column
                                && r > 0 && MineLocations.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && MineLocations.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && MineLocations.mineLocation [k].row == r)
                            tempCellValue++;
                        //If cell down and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && MineLocations.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && r < numberOfRows && MineLocations.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell directly above current cell is mine, add one to tempCellValue.
                        if (MineLocations.mineLocation[k].column == c
                                && r > 0 && MineLocations.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell directly below current cell is mine, add one to tempCellValue.
                        if (MineLocations.mineLocation[k].column == c
                                && r < numberOfRows && MineLocations.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell up and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && MineLocations.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r > 0 && MineLocations.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && MineLocations.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && MineLocations.mineLocation[k].row == r)
                            tempCellValue++;
                        //If cell down and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && MineLocations.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r < numberOfRows && MineLocations.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
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

