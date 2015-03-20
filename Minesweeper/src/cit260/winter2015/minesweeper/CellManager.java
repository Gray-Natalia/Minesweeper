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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Keith Banner
 */
public class CellManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final ArrayList<Cell> cells = new ArrayList<>();
    private static final ArrayList<CheckCell> checkCells = new ArrayList<>();
    private static final ArrayList<CheckCell> checkCellsTemp = new ArrayList<>();

    private static int[][] values;
    private static int[][] states;

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

    private int getNumberOfRows() {
        return cells.get(cells.size() - 1).getRow();
    }

    private char getLastColumn() {
        return cells.get(cells.size() - 1).getColumn();
    }

    private int getNumberOfColumns() {
        return cells.get(cells.size() - 1).getColumn() - 'A' + 1;
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
                } else {
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
        valueArray();
        stateArray();
    }

    public void valueArray() {
        int rows = getNumberOfRows();
        int columns = getNumberOfColumns();

        values = new int[rows][columns];
        for (Cell cell : cells) {
            int row = cell.getRow();
            int column = cell.getColumn() - 65;
            values[row - 1][column] = cell.getValue();
        }
    }

    public void stateArray() {
        int rows = getNumberOfRows();
        int columns = getNumberOfColumns();

        states = new int[rows][columns];
        for (Cell cell : cells) {
            int row = cell.getRow();
            int column = cell.getColumn() - 65;
            states[row - 1][column] = cell.getState();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // During Game
    // Displays Game Board
    public void displayBoardState() {

        // Symbols used in displaying board.
        char undiscovered = 'U';
        char flagged = 'F';
        char unknown = '?';
        char exploded = '*';
        char mine = 'M';
        char incorrectFlag = 'X';
        StringBuilder boardPrint = new StringBuilder("\t   ");

        for (int i = 0; i < getNumberOfColumns(); i++) {
            boardPrint.append("   ")
                    .append((char) (i + 65));
        }
        boardPrint.append("\n\t=====");
        for (int i = 0; i < getNumberOfColumns(); i++) {
            boardPrint.append("====");
        }
        boardPrint.append("\n");

        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                if (column == 0) {
                    boardPrint.append("\t")
                            .append(row + 1)
                            .append(".");
                    if (row < 9) {
                        boardPrint.append(" ");
                    }
                }
                if (states[row][column] == 9) {
                    boardPrint.append("   ")
                            .append(undiscovered);
                } else if (states[row][column] == 10) {
                    boardPrint.append("   ")
                            .append(flagged);
                } else if (states[row][column] == 11) {
                    boardPrint.append("   ")
                            .append(unknown);
                } else if (states[row][column] == 12) {
                    boardPrint.append("   ")
                            .append(exploded);
                } else if (states[row][column] == 13) {
                    boardPrint.append("   ")
                            .append(mine);
                } else if (states[row][column] == 14) {
                    boardPrint.append("   ")
                            .append(incorrectFlag);
                } else if (states[row][column] == 15) {
                    boardPrint.append("   ")
                            .append(mine);
                } else {
                    boardPrint.append("   ")
                            .append(states[row][column]);
                }
            }
            boardPrint.append("\n\t-----");
            for (int i = 0; i < getNumberOfColumns(); i++) {
                boardPrint.append("----");
            }
            boardPrint.append("\n");
        }
        System.out.println(boardPrint);
    }

    public void displayBoardValue() {

        // Symbols used in displaying board.
        char mine = 'M';
        StringBuilder boardPrint = new StringBuilder("\t   ");

        for (int i = 0; i < getNumberOfColumns(); i++) {
            boardPrint.append("   ")
                    .append((char) (i + 65));
        }
        boardPrint.append("\n\t=====");
        for (int i = 0; i < getNumberOfColumns(); i++) {
            boardPrint.append("====");
        }
        boardPrint.append("\n");

        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                if (column == 0) {
                    boardPrint.append("\t")
                            .append(row + 1)
                            .append(".");
                    if (row < 9) {
                        boardPrint.append(" ");
                    }
                }
                if (values[row][column] == 15) {
                    boardPrint.append("   ")
                            .append(mine);
                } else {
                    boardPrint.append("   ")
                            .append(values[row][column]);
                }
            }
            boardPrint.append("\n\t-----");
            for (int i = 0; i < getNumberOfColumns(); i++) {
                boardPrint.append("----");
            }
            boardPrint.append("\n");
        }
        System.out.println(boardPrint);
    }

    // Gets user input for column.
    private char getSelectedColumn() {

        Scanner in = new Scanner(System.in);

        // Variable that stores the letter reperesenting the last column
        String selectedColumn;
        char letterOfLastColumn = getLastColumn();
        char c = 'A';

        System.out.println("Select a column.");

        boolean valid = false; // rightClick to indicate if valid character entered
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
            }
        }
        return c;
    }

    // Get usere input for selected row.
    private int getSelectedRow() {
        Scanner in = new Scanner(System.in);

        // Variable that stores the letter reperesenting the last column
        int lastRow = getLastRow();

        int selectedRow = 0;
        System.out.println("Select a row.");

        boolean valid = false; // rightClick to indicate if valid character entered
        do {
            try {
                // prompt for input
                System.out.println("Enter row value from 1 to " + lastRow + ".");

                // get input from user
                selectedRow = in.nextInt();

                if (selectedRow <= lastRow && selectedRow >= 0) {
                    return selectedRow;
                } else {
                    System.out.println("Invalid input. Please try again.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
                in.next();
            }
        } while (!valid);

        return selectedRow;
    }

    private int getValue(int row, char column) {
        return values[row][column];
    }

    public void inputGetValue() {
        char column = getSelectedColumn();
        int row = getSelectedRow();
        getValue(row, column);
    }

    private void revealCheckCells() {
        for (CheckCell checkCell : checkCells) {
            int row = checkCell.getRow();
            int column = checkCell.getColumn();
            int state = states[row][column];
            int value = values[row][column];
            if (state == 9) {
                switch (value) {
                    case 15:
                        states[row][column] = 12;
                        System.out.println("Game over. You clicked a mine.");
                        break;
                    case 0:
                        states[row][column] = 0;
                        addCheckCellTemp(row + 1, column + 1);
                        addCheckCellTemp(row + 1, column);
                        addCheckCellTemp(row + 1, column - 1);
                        addCheckCellTemp(row, column + 1);
                        addCheckCellTemp(row, column - 1);
                        addCheckCellTemp(row - 1, column + 1);
                        addCheckCellTemp(row - 1, column);
                        addCheckCellTemp(row - 1, column - 1);
                        break;
                    default:
                        states[row][column] = value;
                }
            } else {

            }
        }
        clearCheckCells();
        checkCellTempCopy();

    }

    public void click() {
        int column = getSelectedColumn() - 65;
        int row = getSelectedRow() - 1;
        if (states[row][column] == 10) {
            System.out.println("Flag must be removed before revealing cell.");
        } else if (states[row][column] == 11) {
            System.out.println("Question mark must be removed before revealing cell.");
        } else if (states[row][column] == 9) {
            addCheckCell(row, column);
            revealCheckCells();
            checkWin();
        } else {
            System.out.println("Cell already revealed.");
        }
    }

    // States 0 empty, 1-8 numbers, 9 undiscovered, 10 flaged, 11 unknown
    // Game end only: 12 clicked exploded, 13 undiscovered mine, 14 Incorrect Flag, 15 discovered mine.
    public void rightClick() {
        int column = getSelectedColumn() - 65;
        int row = getSelectedRow() - 1;
        if (states[row][column] == 9) {
            states[row][column] = 10;
        } // Already Flagged - Set Unknown
        else if (states[row][column] == 10) {
            states[row][column] = 11;
        } // Already Unknown - Set Undiscovered
        else if (states[row][column] == 11) {
            states[row][column] = 9;
        }
    }

    // Functionality for when a user clicks with both mouse buttons.
    // Reveals all cells touching number if the number shown has been marked with flags.
    public void twoButtonClick() {
        int columns = getNumberOfColumns() - 1;
        int rows = getNumberOfRows() - 1;
        int column = getSelectedColumn() - 65;
        int row = getSelectedRow() - 1;
        int state = states[row][column];
        int value = values[row][column];
        int counter = 0;
        System.out.println("Column: " + column + " Row: " + row);
        if (state == 9) {
            System.out.println("Can only be used on revealed cells.");
        }
        if (state > 0 && state < 9) {
            if (row < rows && column < columns && states[row + 1][column + 1] == 10) {
                counter++;
                System.out.println(counter + " flag touching.");
            }
            if (row < rows && states[row + 1][column] == 10) {
                counter++;
                System.out.println(counter + " flags touching.");
            }
            if (row < rows && column > 0 && states[row + 1][column - 1] == 10) {
                counter++;
                System.out.println(counter + " flags touching.");
            }
            if (column < columns && states[row][column + 1] == 10) {
                counter++;
                System.out.println(counter + " flags touching.");
            }
            if (column > 0 && states[row][column - 1] == 10) {
                counter++;
                System.out.println(counter + " flags touching.");
            }
            if (row > 0 && column < columns && states[row - 1][column + 1] == 10) {
                counter++;
                System.out.println(counter + " flags touching.");
            }
            if (row > 0 && states[row - 1][column] == 10) {
                counter++;
                System.out.println(counter + " flags touching.");
            }
            if (row > 0 && column > 0 && states[row - 1][column - 1] == 10) {
                counter++;
                System.out.println(counter + " flags touching.");
            }
            if (counter == value) {
                addCheckCell(row + 1, column + 1);
                addCheckCell(row + 1, column + 1);
                addCheckCell(row + 1, column);
                addCheckCell(row + 1, column - 1);
                addCheckCell(row, column + 1);
                addCheckCell(row, column);
                addCheckCell(row, column - 1);
                addCheckCell(row - 1, column + 1);
                addCheckCell(row - 1, column);
                addCheckCell(row - 1, column - 1);
                System.out.println("Checking Cells");
                revealCheckCells();
                checkWin();
            } else {
                System.out.println("Not enough flags.");
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // End Game
    public void checkWin() {
        OUTER:
        {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int column = 0; column < getNumberOfColumns(); column++) {
                    if (states[row][column] == 9 && values[row][column] != 15) {
                        break OUTER;
                    }
                }
            }
            System.out.println("Congratulations, you win!");
            winGame();
        }
    }

    public void winGame() {
        for (int row = 0; row < getNumberOfRows(); row++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                if (states[row][column] == 10 && values[row][column] == 15) {
                    states[row][column] = 15;
                }
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
    private void addCheckCell(int row, int column) {
        if (row >= 0 && row < getNumberOfRows() && column >= 0 && column < getNumberOfColumns()) {
            if (checkCells.size() > 0) {
                for (CheckCell checkCell : checkCells) {
                    if (checkCell.getRow() == row && checkCell.getColumn() == column) {
                    } else {
                        checkCells.add(new CheckCell(row, column));
                    }
                }
            } else {
                checkCells.add(new CheckCell(row, column));
            }
        }
    }

    private void clearCheckCells() {
        try {
            checkCells.clear();
        } catch (NullPointerException e) {

        }
    }

    private void addCheckCellTemp(int row, int column) {
        if (row >= 0 && row < getNumberOfRows() && column >= 0 && column < getNumberOfColumns()) {
            if (checkCellsTemp.size() > 0) {
                for (CheckCell checkCellTemp : checkCellsTemp) {
                    if (checkCellTemp.getRow() == row && checkCellTemp.getColumn() == column) {
                        break;
                    }
                }
                checkCellsTemp.add(new CheckCell(row, column));
            } else {
                checkCellsTemp.add(new CheckCell(row, column));
            }
        }
    }

    private void clearCheckCellsTemp() {
        try {
            checkCellsTemp.clear();
        } catch (NullPointerException e) {

        }
    }

    private void checkCellTempCopy() {
        if (checkCellsTemp.size() > 0) {
            for (CheckCell checkCellTemp : checkCellsTemp) {
                checkCells.add(new CheckCell(checkCellTemp.getRow(), checkCellTemp.getColumn()));
            }
            clearCheckCellsTemp();
            revealCheckCells();
        }
    }
}
