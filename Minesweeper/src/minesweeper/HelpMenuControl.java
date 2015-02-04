/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;


/**
 *
 * @author jacksonrkj
 */
public class HelpMenuControl  {
    
    public HelpMenuControl() {
        
    } 

    public void displayHowToPlay() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println( 
                "\tThe game board for Tic-Tac-Toe. It consist of a grid of "
                + "\n\tlocations. Players place their marker on the different locations "
                + "\n\ton the board in an effort to win the game. The default board is "
                + "\n\t3 rows by 3 columns.");
        displayHelpBorder();
    }
    
    
        
    public void displayBasicStrategies() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\tThe objective of the game is to be the first player to mark three "
                + "\n\tsquares vertically, horizontally or diagonally. Each player takes "
                + "\n\tturns placing their marker in one of the locations on the "
                + "\n\tboard. The first player to get \"three-in-a-row\" is the winner."
                ); 
        displayHelpBorder();
    }
            
    public void displayAbout() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA real player manually takes their turn by placing their mark "
                + "\n\tin an unused location on the board."
                ); 
        displayHelpBorder();
    }
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
