/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author kalav_000
 */
public class InsertionSortOld {
   
    public static void main(String[] args){
        InsertionSortOld insertionSort = new InsertionSortOld();
        insertionSort.InsertionSort();
    }
    public void InsertionSort(){
        int j;
        char tempColumn;
        int tempRow;
        int i;
        
        MineLocations mineLocations = new MineLocations();
        
        for (j = 1; j < mineLocations.mineLocation.length; j++)
        {
            tempColumn = mineLocations.mineLocation [j].column;
            tempRow = mineLocations.mineLocation [j].row;
            for(i = j - 1; (i >= 0 ) && (mineLocations.mineLocation[i].column > tempColumn); i--) //Switched < to > to reverse order of output.
            {
                mineLocations.mineLocation[i+1].column = mineLocations.mineLocation[i].column;
                mineLocations.mineLocation[i+1].row = mineLocations.mineLocation[i].row;
            }
            mineLocations.mineLocation[i+1].column = tempColumn;
            mineLocations.mineLocation[i+1].row = tempRow;
        }
        
        for (int k = 0; k < mineLocations.mineLocation.length; k++){
            System.out.println(mineLocations.mineLocation[k].column + "" + mineLocations.mineLocation[k].row);
        }
        
    }
    
}

    