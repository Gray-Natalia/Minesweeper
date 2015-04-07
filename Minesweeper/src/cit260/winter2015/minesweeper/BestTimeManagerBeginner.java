/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;



/**
 *
 * @author Keith Banner
 */
public class BestTimeManagerBeginner extends BestTimeManager {

    private static final String BEST_TIMES_BEGINNER_FILE = "best_times_beginner.dat";
    

    public BestTimeManagerBeginner() {
        super(BEST_TIMES_BEGINNER_FILE, "Beginner");
    }
    
    public static String getBestTimesString() {
        BestTimeManagerBeginner btmb = new BestTimeManagerBeginner();
        return btmb.setBestTimesString();
    }
}
