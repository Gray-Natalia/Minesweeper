/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Scanner;

/**
 *
 * @author Group
 */
public class GetSelectedCell {
    
    public static void main(String args[]) {
        GetSelectedCell getSelectedCell = new GetSelectedCell();
        getSelectedCell.getInput();
    }
    
    
    public void getInput() {

        String selectedColumn = null;
        String selectedRow = null;
        
        Scanner in = new Scanner(System.in);
        
        int numberOfColumns = 9;
        int numberOfRows = 9;
        int numberOfMines = 10;
        // Variable that stores the letter reperesenting the last column
        char letterOfLastColumn = (char)(numberOfColumns + 'A' - 1);
        
        // Variable for column value to be tested.
        char c;
        
        // Variable for row value to be tested.
        int r;
        
        System.out.println("This program will allow you to see if a cell contains a mine."
                + "\nYou will be asked to enter a column and row value to test the cell. Example A5.");
        
        System.out.println("Please select a column to test.");
        
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("Enter column value from A to " + letterOfLastColumn + ".");
            
            // get input from user           
            selectedColumn = in.nextLine();
                       
            // no marker entered?
            if (selectedColumn == null  || selectedColumn.length() < 1) {
                System.out.println("Invalid input. Please try again.\n");
                continue;
            }
            //the input is bigger than the number of rows or columns
            
            // grab only the first character and convert it to upper case
            selectedColumn = selectedColumn.substring(0, 1).toUpperCase();
            
            // Converts input to char
            c = selectedColumn.charAt(0);
            
            // Repeats loop if input is less than A
            if (c < 'A') {  
                System.out.println("Invalid input. Value entered was less than A.\nPlease try again.\n");
                continue;
            }
            
            // Repeats loop if input is greater than the last column
            if (c > letterOfLastColumn){ 
                System.out.println("Invalid input. Value entered was higher than " + letterOfLastColumn + ".\nPlease try again.\n");
                continue;   
            }
            
            valid = true; // signal that a valid marker was entered
        }
        
        System.out.println("Please select a row to test.");
        
        valid = false;
        while (!valid) {
            // prompt for input
            System.out.println("Enter row value from 1 to " + numberOfRows+ ".");
            
            // get input from user           
            selectedRow = in.nextLine();
           
            // no marker entered?
            if (selectedRow == null  || selectedRow.length() < 1) {
                System.out.println("Invalid input. Please try again.\n");
                continue;
            }
            
            // converts input to integer for row.
            r = Integer.parseInt(selectedRow);
            
            // Repeats loop if selected row is less than 1.
            if (r < 1) {
                System.out.println("Invalid input. Value entered was less than 1.\nPlease try again.\n");
                continue;
            }
            
            // Repeats loop if selected row is greater than last row.
            if (r > numberOfRows) {
                System.out.println("Invalid input. Value entered was higher than " + numberOfRows + ".\nPlease try again.\n");
                continue;
            }
            
            valid = true; // signal that a valid marker was entered
        }
        
        
        
        
        MineLocations mineLocations = new MineLocations();
        
        // Converts input to char
        c = selectedColumn.charAt(0);
        
        // converts input to integer for row.
        r = Integer.parseInt(selectedRow);
        
        for (int i = 0; i < numberOfMines; i++) {
            if (mineLocations.mineLocation[i].column == c
                && mineLocations.mineLocation[i].row == r) {
                System.out.println("Oops, you just blew up. Please play again.");
                break;                
            }
            else {
                if ( i == numberOfMines - 1)
                    System.out.println("YAY! No mine. Please select another column and row.");
            }
                
        }
       
    }
    
}
