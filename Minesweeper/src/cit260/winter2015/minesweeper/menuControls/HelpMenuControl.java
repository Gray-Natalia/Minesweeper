/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.menuControls;

import cit260.winter2015.minesweeper.enums.HelpType;
import cit260.winter2015.minesweeper.exceptions.EndGameException;
import java.io.Serializable;


/**
 *
 * @author Group
 */
public class HelpMenuControl  implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void displayHowToPlay()throws EndGameException {
        System.out.println();
        displayHelpBorder();             
        System.out.println(HelpType.HOW_TO_PLAY.getHelpText());
        displayHelpBorder();
    }
        
    public static void displayBasicStrategies() throws EndGameException {
        System.out.println();
        displayHelpBorder();     
        System.out.println(HelpType.BASIC_STRATEGIES.getHelpText()); 
        displayHelpBorder();
    }
            
    public static void displayAbout() throws EndGameException {
        System.out.println();
        displayHelpBorder();     
        System.out.println(HelpType.ABOUT.getHelpText()); 
        displayHelpBorder();
    }
    
    public static void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
