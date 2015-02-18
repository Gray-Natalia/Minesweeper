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
        InsertionSort insertionSort1 = new InsertionSort();
        insertionSort1.InsertionSort();
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
            for(i = j - 1; (i >= 0) && (mineLocations.mineLocation[i].column >= tempColumn) ; i--) //Switched < to > to reverse order of output.
            {
                //Added if statement for if the column is greater (example column of C7 > column of A5 so condition is fulfilled)
                if (mineLocations.mineLocation[i].column > tempColumn) {                            
                    mineLocations.mineLocation[i+1].column = mineLocations.mineLocation[i].column;
                    mineLocations.mineLocation[i+1].row = mineLocations.mineLocation[i].row;
                }
                //Else if column is equal (example column of C7 == column of C2, but rows are different.)
                //So this checks the row values if the columns are the same. So since C7 and C2 are both C 
                //it checks the number and orders them correctly (A5, B2, C2, C7, D3, E6, F8, G1, H9, I)
                else if (mineLocations.mineLocation[i].column == tempColumn && mineLocations.mineLocation[i].row > tempRow) { 
                    mineLocations.mineLocation[i+1].column = mineLocations.mineLocation[i].column;
                    mineLocations.mineLocation[i+1].row = mineLocations.mineLocation[i].row;
                }
            }
            mineLocations.mineLocation[i+1].column = tempColumn;
            mineLocations.mineLocation[i+1].row = tempRow;
        }
        
        for (int k = 0; k < mineLocations.mineLocation.length; k++){
            System.out.println(mineLocations.mineLocation[k].column + "" + mineLocations.mineLocation[k].row);
        }
        
    }
    
}

    