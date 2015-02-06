/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author kalavic
 */
public class ChooseLevelMenuControl {
    
    public ChooseLevelMenuControl() {
        
    } 

    public void displayBeginner() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        this.displayHelpBorder();             
        System.out.println(
                "\tA board of 8x8 squares appears with 10% of squares with hidden mines. ");
        displayHelpBorder();
    }
        
    public void displayIntermediate() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\tA board of 16x16 squares appears with 10% of squares with hidden mines. ");
        displayHelpBorder();
    }
            
    public void displayExpert() {
        //for now here will be the description of the level, in the future
        //we will create a board of this level
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA board of 24x24 squares appears with 10% of squares with hidden mines. ");
        displayHelpBorder();
    }
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
}
