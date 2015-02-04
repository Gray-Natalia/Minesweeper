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
public class BestTimesMenuControl {
    
    BestTimesPrint bestTimesPrint = new BestTimesPrint();
    
     
    public void beginnerBestTimes() {
        bestTimesPrint.printBeginnerBestTimes();
    }

    public void intermediateBestTimes() {
        bestTimesPrint.printIntermediateBestTimes();        
    }
    
    public void expertBestTimes() {
        bestTimesPrint.printExpertBestTimes();
    }
    
}
