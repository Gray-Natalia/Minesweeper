/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author jacksonrkj
 */
public class GetSelectedCell {
    
    public static void main(String args[]) {
        GetSelectedCell getSelectedCell = new GetSelectedCell();
        getSelectedCell.getInput();
    }
    
    
    public String getInput() {

        String selectedColumn = null;
        String selectedRow = null;
        
        Scanner in = new Scanner(System.in);
        
        int numberOfColumns = 9;
        int numberOfRows = 9;
        
                 
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("Please enter column. A to " + (char)(numberOfColumns + 'A' - 1) );
            
            // get input from user           
            selectedColumn = in.nextLine();
                       
            // no marker entered?
            if (selectedColumn == null  || selectedColumn.length() < 1) {
                continue;
            }
            
            // grab only the first character and convert it to upper case
            selectedColumn = selectedColumn.substring(0, 1).toUpperCase();
            
            valid = true; // signal that a valid marker was entered
        }
        
        valid = false;
        while (!valid) {
            // prompt for input
            System.out.println("Please enter row. 1 to " + numberOfRows);
            
            // get input from user           
            selectedRow = in.nextLine();
           
            // no marker entered?
            if (selectedRow == null  || selectedRow.length() < 1) {
                continue;
            }
            
            // grab only the first character and convert it to upper case
            selectedRow = selectedRow.substring(0, 1).toUpperCase();
            
            valid = true; // signal that a valid marker was entered
        }
        
        return selectedColumn;
    }
    
}
