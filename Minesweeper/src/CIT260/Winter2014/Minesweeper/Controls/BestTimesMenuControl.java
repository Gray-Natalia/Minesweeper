/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.Winter2014.Minesweeper.Controls;

import java.io.Serializable;
import minesweeper.BestTimeManagerBeginner;
import minesweeper.BestTimeManagerExpert;
import minesweeper.BestTimeManagerIntermediate;

/**
 *
 * @author 
 */
public class BestTimesMenuControl implements Serializable {
     
    public static void beginnerBestTimes() {
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        System.out.println(btmb.getBestTimesString());
    }

    public static void intermediateBestTimes() {
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        System.out.println(btmi.getBestTimesString());
    }
    
    public static void expertBestTimes() {
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        System.out.println(btme.getBestTimesString());
    }
    
    public static void allBestTimes() {
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        System.out.println(btmb.getBestTimesString());
        
        BestTimeManagerIntermediate btmi = new BestTimeManagerIntermediate();
        System.out.println(btmi.getBestTimesString());
        
        BestTimeManagerExpert btme = new BestTimeManagerExpert();
        System.out.println(btme.getBestTimesString());
    }
    
}
