/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author group
 */
public class InsertionSort {
   
    public void InsertionSort(){
        int j;
        char tempColumn;
        int tempRow;
        int i;
        
        MineLocationsPreset mineLocationsPreset = new MineLocationsPreset();
        
        for (j = 1; j < mineLocationsPreset.mineLocation.length; j++)
        {
            tempColumn = mineLocationsPreset.mineLocation [j].column;
            tempRow = mineLocationsPreset.mineLocation [j].row;
            for(i = j - 1; (i >= 0 ) && (mineLocationsPreset.mineLocation[i].column > tempColumn|| 
                    (mineLocationsPreset.mineLocation[i].column == tempColumn && mineLocationsPreset.mineLocation[i].row > tempRow)); i--)
            {
                mineLocationsPreset.mineLocation[i+1].column = mineLocationsPreset.mineLocation[i].column;
                mineLocationsPreset.mineLocation[i+1].row = mineLocationsPreset.mineLocation[i].row;
            }
            mineLocationsPreset.mineLocation[i+1].column = tempColumn;
            mineLocationsPreset.mineLocation[i+1].row = tempRow;
        }
        
        for (int k = 0; k < mineLocationsPreset.mineLocation.length; k++){
            System.out.println(mineLocationsPreset.mineLocation[k].column + "" + mineLocationsPreset.mineLocation[k].row);
        }
        
    }
    
}

    