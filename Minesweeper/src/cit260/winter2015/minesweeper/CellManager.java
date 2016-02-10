/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

import cit260.winter2015.minesweeper.enums.CellStates;
import cit260.winter2015.minesweeper.exceptions.LoseGameException;
import cit260.winter2015.minesweeper.exceptions.WinGameException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Keith Banner
 */
public class CellManager implements Serializable {

    private static int rows;
    private static int columns;
    private static int numberOfMines;
    private static int minesRemaining;

    private static final long serialVersionUID = 1L;

    private static final ArrayList<Cell> cells = new ArrayList<>();
    private static final ArrayList<CheckCell> checkCells = new ArrayList<>();
    private static final ArrayList<CheckCell> checkCellsTemp = new ArrayList<>();

    public static int[][] values;
    public static int[][] states;

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public CellManager() {
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
    public void calculateCellValues() {
        clearCells();
        clearCheckCells();
        clearCheckCellsTemp();
        rows = GameVariables.numberOfRows;
        columns = GameVariables.numberOfColumns;
        numberOfMines = GameVariables.numberOfMines;
        minesRemaining = numberOfMines;
        MineManager mm = new MineManager();
        int currentMineCheck = 0;
        int currentRow;
        int tempCellValue;
        char j;
        for (int i = 0; i < rows; i++) {
            currentRow = i + 1;
            for (j = 'A'; j < columns + 'A'; j++) {
                if (currentMineCheck < numberOfMines
                        && mm.getMineColumn(currentMineCheck) == j
                        && mm.getMineRow(currentMineCheck) == currentRow) {
                    addCell(currentRow, j, CellStates.DISCOVERED_MINE.getState(), CellStates.UNDISCOVERED.getState()); // Adds mine.
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
                addCell(currentRow, j, tempCellValue, CellStates.UNDISCOVERED.getState());
            }
        }
        sort();
        valueArray();
        stateArray();
    }

    public void valueArray() {

        values = new int[rows][columns];
        cells.stream().forEach((cell) -> {
            int row = cell.getRow();
            int column = cell.getColumn() - 65;
            values[row - 1][column] = cell.getValue();
        });
    }

    public void stateArray() {

        states = new int[rows][columns];
        cells.stream().forEach((cell) -> {
            int row = cell.getRow();
            int column = cell.getColumn() - 65;
            states[row - 1][column] = cell.getState();
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // During Game
    // Displays number of numberOfMines left
    public int getMinesRemaining() {
        return minesRemaining;
    }

    private void revealCheckCells() throws LoseGameException {
        for (CheckCell checkCell : checkCells) {
            int row = checkCell.getRow();
            int column = checkCell.getColumn();
            int state = states[row][column];
            int value = values[row][column];
            if (state == CellStates.UNDISCOVERED.getState()) {
                switch (value) {
                    case 15:
                        states[row][column] = CellStates.EXPLODED.getState() ;
                        loseGame();
                        break;
                    case 0:
                        states[row][column] = CellStates.EMPTY.getState() ;
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

    public void revealAll() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                states[row][column] = values[row][column];
            }
        }
    }

    public void click(int row, int column) throws LoseGameException, WinGameException {
        if (states[row][column] < CellStates.UNDISCOVERED.getState()) {
            twoButtonClick(row, column);
        }
        if (states[row][column] == CellStates.UNDISCOVERED.getState()) {
            addCheckCell(row, column);
            revealCheckCells();
            checkWin();
        }
    }

    // States 0 empty, 1-8 numbers, 9 undiscovered, 10 flagged, 11 unknown
    // Game end only: 12 clicked exploded, 13 undiscovered mine, 14 Incorrect Flag, 15 discovered mine.
    public void rightClick(int row, int column) {
        if (states[row][column] == CellStates.UNDISCOVERED.getState()) {
            states[row][column] = CellStates.FLAGGED.getState(); // Undiscovered - Set Flag
            minesRemaining--; // Decrease Mine counter
        } else if (states[row][column] == CellStates.FLAGGED.getState()) {
            states[row][column] = CellStates.UNKNOWN.getState(); // Already Flagged - Set Unknown
            minesRemaining++; // Increase Mine counter
        } else if (states[row][column] == CellStates.UNKNOWN.getState()) {
            states[row][column] = CellStates.UNDISCOVERED.getState(); // Already Unknown - Set Undiscovered
        }
    }

    // Functionality for when a user clicks with both mouse buttons.
    // Reveals all cells touching number if the number shown has been marked with flags.
    public void twoButtonClick(int row, int column) throws LoseGameException, WinGameException {
        int state = states[row][column];
        int value = values[row][column];
        int counter = 0;
        if (state == CellStates.UNDISCOVERED.getState()) {
        }
        if (state > CellStates.EMPTY.getState() && state < CellStates.UNDISCOVERED.getState()) {
            try {
                if (row < rows && column < columns && states[row + 1][column + 1] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
                if (row < rows && states[row + 1][column] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
                if (row < rows && column > 0 && states[row + 1][column - 1] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
                if (column < columns && states[row][column + 1] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
                if (column > 0 && states[row][column - 1] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
                if (row > 0 && column < columns && states[row - 1][column + 1] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
                if (row > 0 && states[row - 1][column] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
                if (row > 0 && column > 0 && states[row - 1][column - 1] == CellStates.FLAGGED.getState()) {
                    counter++;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
            }
            if (counter == value) {
                addCheckCellTemp(row + 1, column + 1);
                addCheckCellTemp(row + 1, column + 1);
                addCheckCellTemp(row + 1, column);
                addCheckCellTemp(row + 1, column - 1);
                addCheckCellTemp(row, column + 1);
                addCheckCellTemp(row, column);
                addCheckCellTemp(row, column - 1);
                addCheckCellTemp(row - 1, column + 1);
                addCheckCellTemp(row - 1, column);
                addCheckCellTemp(row - 1, column - 1);
                checkCellTempCopy();
                revealCheckCells();
                checkWin();
            } else {
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // End Game
    public void checkWin() throws WinGameException {
        OUTER:
        {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (states[row][column] == CellStates.UNDISCOVERED.getState()
                            && values[row][column] != CellStates.DISCOVERED_MINE.getState()) {
                        break OUTER;
                    }
                }
            }
            winGame();
        }
    }

    public void winGame() throws WinGameException {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (states[row][column] == CellStates.FLAGGED.getState()
                        && values[row][column] == CellStates.DISCOVERED_MINE.getState()) {
                    states[row][column] = CellStates.DISCOVERED_MINE.getState(); // Discovered Mine
                } else if (states[row][column] == CellStates.FLAGGED.getState() 
                        && values[row][column] != CellStates.DISCOVERED_MINE.getState()) {
                    states[row][column] = CellStates.INCORRECT_FLAG.getState(); // Incorrect Flag
                } else if (states[row][column] == CellStates.UNDISCOVERED.getState()) {
                    states[row][column] = values[row][column];
                }
            }
        }
        throw new WinGameException();
    }

    public void loseGame() throws LoseGameException {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (states[row][column] == CellStates.FLAGGED.getState()
                        && values[row][column] == CellStates.DISCOVERED_MINE.getState()) {
                    states[row][column] = CellStates.DISCOVERED_MINE.getState(); // Discovered Mine
                } else if (states[row][column] == CellStates.FLAGGED.getState()
                        && values[row][column] != CellStates.DISCOVERED_MINE.getState()) {
                    states[row][column] = CellStates.INCORRECT_FLAG.getState(); // Incorrect Flag
                }
            }
        }
        throw new LoseGameException();
    }

    // For checking for zeros.
    private void addCheckCell(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
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
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
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

    private void checkCellTempCopy() throws LoseGameException {
        if (checkCellsTemp.size() > 0) {
            for (CheckCell checkCellTemp : checkCellsTemp) {
                checkCells.add(new CheckCell(checkCellTemp.getRow(), checkCellTemp.getColumn()));
            }
            clearCheckCellsTemp();
            revealCheckCells();
        }
    }
}
