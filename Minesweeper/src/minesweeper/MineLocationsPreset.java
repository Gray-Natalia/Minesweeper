/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author knban_000
 */
public class MineLocationsPreset implements Serializable{
    int numberOfMines = 10;
    
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
    
    public char column;
    public int row;
    
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
}
