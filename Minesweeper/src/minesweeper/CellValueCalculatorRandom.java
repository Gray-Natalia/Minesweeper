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
    
    public static void main(String args[]) 
    throws java.io.IOException {
        CellValueCalculatorRandom cellValueCalculatorRandom = new CellValueCalculatorRandom();
        cellValueCalculatorRandom.ChooseDifficultyLevel();
//        cvcr.calculateNumMines();
    }
    
    public int numberOfMines;
    public int numberOfColumns;
    public int numberOfRows;
    public int numberOfCells = numberOfColumns * numberOfRows;
    
    CellValueCalculatorRandom[] mineLocation = new CellValueCalculatorRandom[numberOfMines];
    
    CellValue[] cellValueOut = new CellValue[numberOfCells];
    
    public CellValueCalculatorRandom() {
        for (int i = 0; i < numberOfMines; i++){
            mineLocation[i] = new CellValueCalculatorRandom((char)('A' + (char) (Math.random() * numberOfColumns)), 1+ (int) (Math.random() * numberOfRows));
            System.out.println("Array number " + i + "created");
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
    public String difficultyLevel;
    
    
    
    public CellValueCalculatorRandom(char col, int ro) {
        column = col;
        row = ro;
    }
    
    public void ChooseDifficultyLevel()
        throws java.io.IOException {
        
        int choice;
        
        System.out.println("Please Select Game Difficulty");
        System.out.println("   1. Beginner (9x9 grid with 10 mines.)");
        System.out.println("   2. Intermediate (16x16 grid with 40 mines.");
        System.out.println("   3. Expert (30x16 grid with 99 mines.");
        System.out.println("Please enter the number of the game you would like to play.");
        
        choice = (int) System.in.read();
        switch(choice) {
            case '1' :
                numberOfMines = 10;
                numberOfColumns = 9;
                numberOfRows = 9;
                difficultyLevel = "Beginner";
                break;
            case '2' :
                numberOfMines = 40;
                numberOfColumns = 16;
                numberOfRows = 16;
                difficultyLevel = "Intermediate";
                break;
            case '3' :
                numberOfMines = 99;
                numberOfColumns = 30;
                numberOfRows = 16;
                difficultyLevel = "Expert"; 
                break;
            default :
                System.out.println("Invalid selection. Please try again.");
                System.out.println("Only 1, 2, and 3 are valid inputs.");
        }
        
        System.out.println("You have selected " + difficultyLevel + ". There are " 
                + numberOfRows + " rows, " + numberOfColumns + " columns, and " 
                + numberOfMines + " mines.");
    }
    
    public void calculateNumMines() {
        CellValueCalculatorRandom cellValueCalculatorRandom = new CellValueCalculatorRandom();
        int j = 0; //Counter for new cellValueBeginner array index.
        for (int r = 1; r <= numberOfRows; r++) {
            for (char c = 'A'; c <= 'A' +numberOfColumns - 1; c++) {
                minefound:   {
                    for (int i = 0; i < numberOfMines; i++) {
                        if (cellValueCalculatorRandom.mineLocation[i].column == c //checks if a mine matches current row
                                && cellValueCalculatorRandom.mineLocation[i].row == r) { //and column.
                            cellValueOut[j] = new CellValue(c, r, 10); //value of 10 means mine.
                            break minefound;
                        }
                    }
                    int tempCellValue = 0;
                    for (int k = 0; k < numberOfMines; k++) { //counter for loop to calculate cell value.

                        //If cell up and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cellValueCalculatorRandom.mineLocation[k].column == (c-1) // Left one column. Skips if first column
                                && r > 0 && cellValueCalculatorRandom.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cellValueCalculatorRandom.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && cellValueCalculatorRandom.mineLocation [k].row == r)
                            tempCellValue++;
                        //If cell down and to the left of current cell is mine, add one to tempCellValue.
                        if (c > 'A' && cellValueCalculatorRandom.mineLocation[k].column == (c-1) //Left one column. Skips if first column
                                && r < numberOfRows && cellValueCalculatorRandom.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell directly above current cell is mine, add one to tempCellValue.
                        if (cellValueCalculatorRandom.mineLocation[k].column == c
                                && r > 0 && cellValueCalculatorRandom.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell directly below current cell is mine, add one to tempCellValue.
                        if (cellValueCalculatorRandom.mineLocation[k].column == c
                                && r < numberOfRows && cellValueCalculatorRandom.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
                            tempCellValue++;
                        //If cell up and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cellValueCalculatorRandom.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r > 0 && cellValueCalculatorRandom.mineLocation[k].row == (r-1)) //Up one row. Skips if first row
                            tempCellValue++;
                        //If cell to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cellValueCalculatorRandom.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && cellValueCalculatorRandom.mineLocation[k].row == r)
                            tempCellValue++;
                        //If cell down and to the right of current cell is mine, add one to tempCellValue.
                        if (c < 'A' + numberOfColumns && cellValueCalculatorRandom.mineLocation[k].column == (c+1) //Right one column. Skips if last column
                                && r < numberOfRows && cellValueCalculatorRandom.mineLocation[k].row == (r+1)) //Down one row. Skips if last row
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

