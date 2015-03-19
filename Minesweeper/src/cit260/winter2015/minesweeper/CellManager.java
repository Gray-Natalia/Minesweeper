/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Keith Banner
 */
public class CellManager implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private static final ArrayList<Cell> cells = new ArrayList<>();
    private static final ArrayList<CheckCell> checkCells = new ArrayList<>();

    public ArrayList<Cell> getCells() {
        return cells;
    }
    
//    public CellManager(ArrayList<Cell> cells) {
//        cells = new ArrayList<>();
//    }

    public CellManager() {
    }

    private int getLastRow() {
        return cells.get(cells.size() - 1).getRow();
    }

    private char getLastColumn() {
        return cells.get(cells.size() - 1).getColumn();
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // Before Game
    public void sort() {
        CellCompare compare = new CellCompare();
        Collections.sort(cells, compare);
    }

    public void addCell(int row, char column, int value, int state) {
        cells.add(new Cell(row, column, value, state));
    }

    public void clearCells() {
        try {
            cells.clear();
        } catch (NullPointerException e) {

        }
    }

    private class CellCompare implements Comparator<Cell> {

        @Override
        public int compare(Cell cell1, Cell cell2) {
            int c1r = cell1.getRow();
            int c2r = cell2.getRow();

            char c1c = cell1.getColumn();
            char c2c = cell2.getColumn();

            if (c1r < c2r) {
                return -1;
            } else if (c1r == c2r) {
                if (c1c < c2c) {
                    return -1;
                } else if (c1c == c2c) {
                    System.out.println("Duplicate Cell");
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    // Values: 0 empty, 1-8 numbers, 15 mine
    // State: 9 undiscovered.
    public void calculateCellValues(int rows, int columns, int mines) {
        clearCells();
        clearCheckCells();
        MineManager mm = new MineManager();
        int currentMineCheck = 0;
        int currentRow;
        int tempCellValue;
        char j;
        for (int i = 0; i < rows; i++) {
            currentRow = i + 1;
            for (j = 'A'; j < columns + 'A'; j++) {
                if (currentMineCheck < mines
                        && mm.getMineColumn(currentMineCheck) == j
                        && mm.getMineRow(currentMineCheck) == currentRow) {
                    addCell(currentRow, j, 15, 9); // Adds mine.
                    currentMineCheck++;
                    continue;
                }
                else {
                    tempCellValue = 0;
                    for (int k = 0; k < mm.getMines().size(); k++) {

                        //If cell up and to the left of current cell is mine, add one to tempCellValue.
                        if (j > 'A' && mm.getMineColumn(k) == (j - 1) // Left one column. Skips if first column
                                && currentRow > 0 && mm.getMineRow(k) == (currentRow - 1)) //Up one row. Skips if first row
                        {
                            tempCellValue++;
                        }
                        //If cell left of current cell is mine, add one to tempCellValue.
                        if (j > 'A' && mm.getMineColumn(k) == (j - 1) //Left one column. Skips if first column
                                && mm.getMineRow(k) == currentRow) {
                            tempCellValue++;
                        }
                        //If cell down and to the left of current cell is mine, add one to tempCellValue.
                        if (j > 'A' && mm.getMineColumn(k) == (j - 1) //Left one column. Skips if first column
                                && currentRow < rows && mm.getMineRow(k) == (currentRow + 1)) //Down one row. Skips if last row
                        {
                            tempCellValue++;
                        }
                        //If cell directly above current cell is mine, add one to tempCellValue.
                        if (mm.getMineColumn(k) == j
                                && currentRow > 0 && mm.getMineRow(k) == (currentRow - 1)) //Up one row. Skips if first row
                        {
                            tempCellValue++;
                        }
                        //If cell directly below current cell is mine, add one to tempCellValue.
                        if (mm.getMineColumn(k) == j
                                && currentRow < rows && mm.getMineRow(k) == (currentRow + 1)) //Down one row. Skips if last row
                        {
                            tempCellValue++;
                        }
                        //If cell up and to the right of current cell is mine, add one to tempCellValue.
                        if (j < 'A' + columns && mm.getMineColumn(k) == (j + 1) //Right one column. Skips if last column
                                && currentRow > 0 && mm.getMineRow(k) == (currentRow - 1)) //Up one row. Skips if first row
                        {
                            tempCellValue++;
                        }
                        //If cell to the right of current cell is mine, add one to tempCellValue.
                        if (j < 'A' + columns && mm.getMineColumn(k) == (j + 1) //Right one column. Skips if last column
                                && mm.getMineRow(k) == currentRow) {
                            tempCellValue++;
                        }
                        //If cell down and to the right of current cell is mine, add one to tempCellValue.
                        if (j < 'A' + columns && mm.getMineColumn(k) == (j + 1) //Right one column. Skips if last column
                                && currentRow < rows && mm.getMineRow(k) == (currentRow + 1)) //Down one row. Skips if last row
                        {
                            tempCellValue++;
                        }
                    }
                }
                addCell(currentRow, j, tempCellValue, 9);
            }
        }
        sort();
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // During Game
    // Displays Game Board
    public void displayBoard() {
        
        int currentCell = 0;
        int currentRow = 1;
        int counter = 0;
        
        // Symbols used in displaying board.
        char undiscovered = 'U';
        char flagged = 'F';
        char unknown = '?';
        char exploded = '*';
        char mine = 'M';
        char incorrectFlag = 'X';
        
        StringBuilder boardPrint = new StringBuilder("\t  ");
        while (cells.get(currentCell).getRow() == 1) {
            boardPrint.append("   ")
                    .append(cells.get(currentCell).getColumn());
            currentCell++;
        }
        boardPrint.append("\n\t==========================================================================");
        currentCell = 0;
        boardPrint.append("\n");
        while (currentCell < cells.size()) { //Rows
            if (cells.get(currentCell).getColumn() == 'A' && (counter % 2 == 0)) {
                boardPrint.append("\t")
                        .append(currentRow)
                        .append(".");
                if (currentRow < 10) {
                    boardPrint.append(" ");
                }
                counter++;
            }
            if (cells.get(currentCell).getRow() == currentRow) {
                if(cells.get(currentCell).getState() == 9) {
                    boardPrint.append("   ")
                        .append(undiscovered);
                }
                else if(cells.get(currentCell).getState() == 10){
                    boardPrint.append("   ")
                        .append(flagged);
                }
                else if(cells.get(currentCell).getState() == 11){
                    boardPrint.append("   ")
                        .append(unknown);
                }
                else if(cells.get(currentCell).getState() == 12){
                    boardPrint.append("   ")
                        .append(exploded);
                }
                else if(cells.get(currentCell).getState() == 13){
                    boardPrint.append("   ")
                        .append(mine);
                }
                else if(cells.get(currentCell).getState() == 14){
                    boardPrint.append("   ")
                        .append(incorrectFlag);
                }
                else if(cells.get(currentCell).getState() == 15){
                    boardPrint.append("   ")
                        .append(mine);
                }
                else {
                    boardPrint.append("   ")
                            .append(cells.get(currentCell).getState());
                }
                currentCell++;
            } else {
                currentRow++;
                counter++;
                boardPrint.append("\n\t--------------------------------------------------------------------------\n");
            }
        }
        System.out.println(boardPrint);
    }

    // Gets user input for column.
    private char getSelectedColumn() {

        Scanner in = new Scanner(System.in);

        // Variable that stores the letter reperesenting the last column
        CellManager cm = new CellManager();
        String selectedColumn = null;
        char letterOfLastColumn = cm.getLastColumn();
        char c = 'A';

        System.out.println("Select a column.");

        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("Enter column value from A to " + letterOfLastColumn + ".");

            // get input from user           
            selectedColumn = in.nextLine();

            // no marker entered?
            if (selectedColumn == null || selectedColumn.length() < 1) {
                System.out.println("Invalid input. Please try again.\n");
                continue;
            }
            // grab only the first character and convert it to upper case
            selectedColumn = selectedColumn.substring(0, 1).toUpperCase();

            // Converts input to char
            c = selectedColumn.charAt(0);

            if (c >= 'A' && c <= letterOfLastColumn) {
                return c;
            } else {
                System.out.println("Invalid input. Please try again.\n");
                continue;
            }
        }
        return c;
    }

    // Get usere input for selected row.
    private int getSelectedRow() {
        Scanner in = new Scanner(System.in);

        // Variable that stores the letter reperesenting the last column
        CellManager cm = new CellManager();
        int lastRow = cm.getLastRow();

        int selectedRow = 0;
        System.out.println("Select a row.");

        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("Enter row value from 1 to " + lastRow + ".");

            // get input from user           
            selectedRow = in.nextInt();

            if (selectedRow <= lastRow && selectedRow >= 0) {
                return selectedRow;
            } else {
                System.out.println("Invalid input. Please try again.\n");
            }
        }
        return selectedRow;
    }

    private int getValue(int row, char column) {
        int value = 0;
        for (Cell cell : cells) {
            if (cell.getRow() == row && cell.getColumn() == column) {
                value = cell.getValue();
            }
        }
        return value;
    }
    
    public void inputGetValue() {
        char column = getSelectedColumn();
        int row = getSelectedRow();
        getValue(row, column);
    }

    private void reveal(int inputRow, char inputColumn) {
        for (Cell cell : cells) {
            char c = cell.getColumn();
            int r = cell.getRow();
            int v = cell.getValue();
            int s = cell.getState();
            if (s == 9 && r == inputRow && c == inputColumn) {
                switch (v) {
                    case 15:
                        cell.setState(12);
                        System.out.println("Game over. You clicked a mine.");
                        break;
                    case 0:
                        cell.setState(0);
                        addCheckCell(++inputRow, ++inputColumn);
                        addCheckCell(++inputRow, inputColumn);
                        addCheckCell(++inputRow, --inputColumn);
                        addCheckCell(inputRow, ++inputColumn);
                        addCheckCell(inputRow, inputColumn);
                        addCheckCell(inputRow, --inputColumn);
                        addCheckCell(--inputRow, ++inputColumn);
                        addCheckCell(--inputRow, inputColumn);
                        addCheckCell(--inputRow, --inputColumn);
                        break;
                    default:
                        cell.setState(v);
                }
            }
        }
        if (checkCells.size() > 0) {
            for (CheckCell checkCell : checkCells) {
                int checkRow = checkCell.getRow();
                char checkColumn = checkCell.getColumn();
                for (Cell cell : cells) {
                    char c = cell.getColumn();
                    int r = cell.getRow();
                    int v = cell.getValue();
                    int s = cell.getState();
                    if (s == 9 && r == checkRow && c == checkColumn && v == 0) {
                        cell.setState(0);
//                        addCheckCell(checkRow++, checkColumn++);
//                        addCheckCell(checkRow++, checkColumn)  ;
//                        addCheckCell(checkRow++, checkColumn--);
//                        addCheckCell(checkRow  , checkColumn++);
//                        addCheckCell(checkRow  , checkColumn)  ;
//                        addCheckCell(checkRow  , checkColumn--);
//                        addCheckCell(checkRow--, checkColumn++);
//                        addCheckCell(checkRow--, checkColumn)  ;
//                        addCheckCell(checkRow--, checkColumn--);
                    }
                    else if (s == 9 && r == checkRow && c == checkColumn) {
                        cell.setState(v);
                    }
                }
            }
        }
    }
    
    public void clickReveal() {
        char column = getSelectedColumn();
        int row = getSelectedRow();
        reveal(row, column);
    }

    // States 0 empty, 1-8 numbers, 9 undiscovered, 10 flaged, 11 unknown
    // Game end only: 12 clicked exploded, 13 undiscovered mine, 14 Incorrect Flag, 15 discovered mine.
    private void flag(int row, char column) {
        for (Cell cell : cells) {
            if (cell.getRow() == row && cell.getColumn() == column) {
                cell.setState(10);
            }
        }
    }
    
    public void clickFlag() {
        char column = getSelectedColumn();
        int row = getSelectedRow();
        flag(row, column);
    }

    private void unknown(int row, char column) {
        for (Cell cell : cells) {
            if (cell.getRow() == row && cell.getColumn() == column) {
                cell.setState(11);
            }
        }
    }
    
    public void clickUnknown() {
        char column = getSelectedColumn();
        int row = getSelectedRow();
        unknown(row, column);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // End Game
    public void winGame() {
        for (Cell cell : cells) {
            if (cell.getState() < 9) {
            } // Number already revealed.
            else if (cell.getState() == 9 && cell.getValue() < 9) {
                cell.setState(cell.getValue());
                // Reveals Number
            } else if (cell.getState() == 9 && cell.getValue() == 15) {
                cell.setState(13); // Undiscovered Mine
            } else if (cell.getState() == 10 && cell.getValue() == 15) {
                cell.setState(15); // Discovered Mine
            } else if (cell.getState() == 10 && cell.getValue() != 15) {
                cell.setState(14); // Incorrect Flag
            }
        }
    }

    public void loseGame() {
        for (Cell cell : cells) {
            if (cell.getState() == 10 && cell.getValue() == 15) {
                cell.setState(15); // Discovered Mine
            } else if (cell.getState() == 10 && cell.getValue() != 15) {
                cell.setState(14); // Incorrect Flag
            }
        }
    }
    
    // For checking for zeros.
    private void addCheckCell(int row, char column) {
//        if (checkCells.size() > 0) {
//            for (CheckCell checkCell : checkCells) {
//                if (checkCell.getRow() == row && checkCell.getColumn() == column) {
//                }
//                else {
//                    checkCells.add(new CheckCell(row, column));
//                }
//            }
//        }
//        else {
            checkCells.add(new CheckCell(row, column));
//        }
    }
    
    private void removeCheckCell(int row, char column) {
        for (int i = 0; i < checkCells.size(); i++) {
            if (checkCells.get(i).getRow() == row && checkCells.get(i).getColumn() == column) {
                checkCells.remove(checkCells.get(i));
            }
            else {
            }
        }
    }

    private void clearCheckCells() {
        try {
            checkCells.clear();
        } catch (NullPointerException e) {

        }
    }
}
