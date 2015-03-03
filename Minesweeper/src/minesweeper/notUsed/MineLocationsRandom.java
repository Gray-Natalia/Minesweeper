/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.notUsed;

import minesweeper.ConstructorMineArray;

/**
 *
 * @author knban_000
 */

public class MineLocationsRandom{

    
    
    
    public static void MineGenerator(int columns, int rows, int mines) {
        ConstructorMineArray[] mineLocation = new ConstructorMineArray[mines];
        for (int i = 0; i < mines; i++){
            mineLocation[i] = new ConstructorMineArray((char)('A' + (char) (Math.random() * numberOfColumns)), 1+ (int) (Math.random() * numberOfRows));
            for (int j = 0; j < i; j++){                
                while (mineLocation[i].column == mineLocation[j].column && mineLocation[i].row == mineLocation[j].row) {
                    mineLocation[i] = new ConstructorMineArray((char)('A' + (char) (Math.random() * numberOfColumns)), 1+ (int) (Math.random() * numberOfRows));
                }
            }
        }
    }
    
    public void SortMines(int columns, int rows, int mines) {
        MineLocationsRandom mineLocationsR = new MineLocationsRandom();
        int k;
        for (int j = 1; j < mineLocationsR.mineLocation.length; j++){
            char tempColumn = mineLocationsR.mineLocation [j].column;
            int tempRow = mineLocation [j].row;
            for(k = j - 1; (k >= 0 ) && (mineLocation[k].column > tempColumn
                    || (mineLocation[k].column == tempColumn && mineLocation[k].row > tempRow)); k--)
            {
                mineLocation[k+1].column = mineLocation[k].column;
                mineLocation[k+1].row = mineLocation[k].row;
            }
            mineLocation[k+1].column = tempColumn;
            mineLocation[k+1].row = tempRow;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(mineLocation[i].column + "" + mineLocation[i].row);
        }
    }
}
