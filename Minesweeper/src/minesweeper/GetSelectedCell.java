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
    
    
    
    /*
     * default constructor
     */
    
    
    public String getInput(Player player) {

        String selectedCell = null;
        Scanner in = new Scanner(System.in);
        
        int numberOfColumns = 9;
        
                 
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("Please enter column. A to " + (char)(numberOfColumns + 'A') );
            
            // get input from user           
            selectedCell = in.nextLine();
           
            // no marker entered?
            if (selectedCell == null  || selectedCell.length() < 1) {
                continue;
            }
            
            // grab only the first character and convert it to upper case
            selectedCell = selectedCell.substring(0, 1).toUpperCase();
            
            if (selectedCell.equals("Q")) { // Quit?
                return null;
            }
            
            // Check to see if the marker is already in use
            if (this.game.playerA.marker.equals(selectedCell) ||
                this.game.playerB.marker.equals(selectedCell) ) {
               new TicTacToeError().displayError(
                        "This marker is currently in use. " +
                        "Select a different character");
               continue; 
            }
            
            valid = true; // signal that a valid marker was entered
        }
        
        return selectedCell;
    }
    
}
