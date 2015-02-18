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
public class InsertionSort {
   
    public static void main(String[] args){
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort();
    }
    public void InsertionSort(){
        int j;
        char key;
        int key2;
        int i;
        
        MineLocations mineLocations = new MineLocations();
        
        for (j = 1; j < mineLocations.mineLocation.length; j++)
        {
            key = mineLocations.mineLocation [ j ].column;
            key2 = mineLocations.mineLocation [ j ].row;
            for(i = j-1; (i >=0 ) && (mineLocations.mineLocation[ i ].column < key); i--)
            {
                mineLocations.mineLocation[ i+1 ].column = mineLocations.mineLocation[ i ].column;
                mineLocations.mineLocation[ i+1 ].row = mineLocations.mineLocation[ i ].row;
            }
            mineLocations.mineLocation[ i+1 ].column = key;
            mineLocations.mineLocation[ i+1 ].row = key2;
        }
        
        for (int k = 0; k < mineLocations.mineLocation.length; k++){
            System.out.println(mineLocations.mineLocation[ k ].column + "" + mineLocations.mineLocation[ k ].row);
        }
        
    }
    
}

    