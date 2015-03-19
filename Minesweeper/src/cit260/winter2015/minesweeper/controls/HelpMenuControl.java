/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.controls;

import cit260.winter2015.minesweeper.enums.HelpType;
import java.io.Serializable;


/**
 *
 * @author Group
 */
public class HelpMenuControl  implements Serializable {
    private static final long serialVersionUID = 1L;

    public void displayHowToPlay() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println(HelpType.HOW_TO_PLAY.getHelpText());
        displayHelpBorder();
    }
        
    public void displayBasicStrategies() {
        System.out.println();
        displayHelpBorder();     
        System.out.println(HelpType.BASIC_STRATEGIES.getHelpText()); 
        displayHelpBorder();
    }
            
    public void displayAbout() {
        System.out.println();
        displayHelpBorder();     
        System.out.println(HelpType.ABOUT.getHelpText()); 
        displayHelpBorder();
    }
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
