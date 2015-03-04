/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class BestTimesMenuControl implements Serializable {
     
    public static void beginnerBestTimes() {
        BestTimesPrint.printBeginnerBestTimes();
    }

    public static void intermediateBestTimes() {
        BestTimesPrint.printIntermediateBestTimes();        
    }
    
    public static void expertBestTimes() {
        BestTimesPrint.printExpertBestTimes();
    }
}
