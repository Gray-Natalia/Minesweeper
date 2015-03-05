/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author knban_000
 */
public class MineLocationsPreset implements Serializable{
    private int numberOfMines = 10;
    char column;
    int row;
    
    MineLocationsPreset[] mineLocation = new MineLocationsPreset[numberOfMines];
    
    public MineLocationsPreset() {
            mineLocation[0] = new MineLocationsPreset('D',9);
            mineLocation[1] = new MineLocationsPreset('C',2);
            mineLocation[2] = new MineLocationsPreset('H',7);
            mineLocation[3] = new MineLocationsPreset('G',5);
            mineLocation[4] = new MineLocationsPreset('E',7);
            mineLocation[5] = new MineLocationsPreset('G',4);
            mineLocation[6] = new MineLocationsPreset('E',8);
            mineLocation[7] = new MineLocationsPreset('G',2);
            mineLocation[8] = new MineLocationsPreset('A',2);
            mineLocation[9] = new MineLocationsPreset('F',3);
    }
    
    public MineLocationsPreset(char col, int ro) {
        column = col;
        row = ro;
    }
    
    public void SortMines() {
        int k;
        for (int j = 1; j < mineLocation.length; j++)
        {
            char tempColumn = mineLocation [j].column;
            int tempRow = mineLocation [j].row;
            for(k = j - 1; (k >= 0 ) && (mineLocation[k].column > tempColumn|| 
                    (mineLocation[k].column == tempColumn && mineLocation[k].row > tempRow)); k--)
            {
                mineLocation[k+1].column = mineLocation[k].column;
                mineLocation[k+1].row = mineLocation[k].row;
            }
            mineLocation[k+1].column = tempColumn;
            mineLocation[k+1].row = tempRow;
        }
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public MineLocationsPreset[] getMineLocation() {
        return mineLocation;
    }

    public void setMineLocation(MineLocationsPreset[] mineLocation) {
        this.mineLocation = mineLocation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.numberOfMines;
        hash = 17 * hash + this.column;
        hash = 17 * hash + this.row;
        hash = 17 * hash + Arrays.deepHashCode(this.mineLocation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MineLocationsPreset other = (MineLocationsPreset) obj;
        if (this.numberOfMines != other.numberOfMines) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (!Arrays.deepEquals(this.mineLocation, other.mineLocation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MineLocationsPreset{" + "numberOfMines=" + numberOfMines + ", column=" + column + ", row=" + row + ", mineLocation=" + mineLocation + '}';
    }
    
    
}
