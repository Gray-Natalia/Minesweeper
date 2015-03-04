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
public class CellNumberCalculatorPreset {
    
    public int numberOfMines = 10;
    public int numberOfColumns = 9;
    public int numberOfRows = 9;
    public int numberOfCells = numberOfColumns * numberOfRows;

    
    ConstructorCellOutputArray[] cellValueOut = new ConstructorCellOutputArray[numberOfCells];
    
    public void calculateNumMines() {
        MineLocationsPreset mineLocations = new MineLocationsPreset();
        mineLocations.SortMines();
        int j; //Counter for new cellValueBeginner array index.
        int currentMineCheck = 0;
        for (char c = 'A'; c <= 'A' + numberOfColumns - 1; c++) {
            j = (int)c - 65; // Converts the char into an int with A equal to 0.
            for (int r = 1; r <= numberOfRows; r++) {
                if (currentMineCheck !=mineLocations.mineLocation.length 
                    && mineLocations.mineLocation[currentMineCheck].column == c 
                    && mineLocations.mineLocation[currentMineCheck].row == r) {
                    //if it is a mine then:
                    cellValueOut[j] = new ConstructorCellOutputArray(c, r, 10); //value of 10 means mine.
                    currentMineCheck += 1;
                }
                //if not a mine then:
                else {
                    int tempCellValue = 0; //How many mines are touching the cell.
                    for (int k = 0; k < numberOfMines; k++) { //counter for loop to calculate cell value.

                        //If cell up and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && mineLocations.mineLocation[k].column == (c-1) // Left one column. Skips if first column
                                && r > 0 && mineLocations.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && mineLocations.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && mineLocations.mineLocation [k].row == r)
                            tempCellValue++;
                        //If cell down and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && mineLocations.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && r < numberOfRows && mineLocations.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell directly above current cell is mine, add one to tempCellValue.
                        if (mineLocations.mineLocation[k].column == c
                                && r > 0 && mineLocations.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell directly below current cell is mine, add one to tempCellValue.
                        if (mineLocations.mineLocation[k].column == c
                                && r < numberOfRows && mineLocations.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell up and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && mineLocations.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r > 0 && mineLocations.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && mineLocations.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && mineLocations.mineLocation[k].row == r)
                            tempCellValue++;
                        //If cell down and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && mineLocations.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r < numberOfRows && mineLocations.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                    cellValueOut[j] = new ConstructorCellOutputArray(c, r, tempCellValue);
                    }
                }
                j += numberOfColumns;
            }
        }
        for(int k1 = 0; k1 < numberOfColumns; k1++) { 
            for(int k2 = k1*numberOfColumns; k2 < (k1+1)*numberOfColumns; k2++) {
                if (cellValueOut[k2].cellValue == 10)
                    System.out.print("M\t");
                else System.out.print(cellValueOut[k2].cellValue + "\t");
            }
            System.out.print("\n");
        }
    }
}

