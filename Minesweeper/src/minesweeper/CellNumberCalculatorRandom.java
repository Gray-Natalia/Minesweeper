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
public class CellNumberCalculatorRandom extends GameVariables{
    
    public static void main(String args[]) {
        CellNumberCalculatorRandom cellNumberCalculator = new CellNumberCalculatorRandom();
        cellNumberCalculator.calculateNumMines();
        
    }
   
    ConstructorCellOutputArray[] cellValueOut = new ConstructorCellOutputArray[numberOfCells];
    
    public void calculateNumMines() {
        System.out.println("playerName = " + playerName + " numberOfColumns = " + numberOfColumns + " numberOfRows = " + numberOfRows + " numberOfMines = " + numberOfMines + " numberOfCells = " + numberOfCells);
        MineLocationsRandom mineLocationsR = new MineLocationsRandom();
        mineLocationsR.SortMines();
        int j; //Counter for new cellValueOut array index.
        int currentMineCheck = 0;
        for (char c = 'A'; c <= 'A' + numberOfColumns - 1; c++) {
            j = (int)c - 65; // Converts the char into an int with A equal to 0.
            for (int r = 1; r <= numberOfRows; r++) {
                if (currentMineCheck !=mineLocationsR.mineLocation.length 
                        && mineLocationsR.mineLocation[currentMineCheck].column == c 
                        && mineLocationsR.mineLocation[currentMineCheck].row == r) {
                    cellValueOut[j] = new ConstructorCellOutputArray(c, r, 10); //value of 10 means mine.
                        currentMineCheck += 1;
                }
                else {
                    int tempCellValue = 0;
                    for (int k = 0; k < numberOfMines; k++) { //counter for loop to calculate cell value.

                        //If cell up and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && mineLocationsR.mineLocation[k].column == (c-1) // Left one column. Skips if first column
                                && r > 0 && mineLocationsR.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && mineLocationsR.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && mineLocationsR.mineLocation [k].row == r)
                            tempCellValue++;
                        //If cell down and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && mineLocationsR.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && r < numberOfRows && mineLocationsR.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell directly above current cell is mine, add one to tempCellValue.
                        if (mineLocationsR.mineLocation[k].column == c
                                && r > 0 && mineLocationsR.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell directly below current cell is mine, add one to tempCellValue.
                        if (mineLocationsR.mineLocation[k].column == c
                                && r < numberOfRows && mineLocationsR.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell up and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && mineLocationsR.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r > 0 && mineLocationsR.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && mineLocationsR.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && mineLocationsR.mineLocation[k].row == r)
                            tempCellValue++;
                        //If cell down and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && mineLocationsR.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r < numberOfRows && mineLocationsR.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                    }
                    cellValueOut[j] = new ConstructorCellOutputArray(c, r, tempCellValue);
                }
                j += 9;
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

