/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Comparator;

/**
 *
 * @author knban_000
 */
public class BestTimeCompare implements Comparator<BestTime> {
    @Override
    public int compare(BestTime bestTime1, BestTime bestTime2) {
        double bt1 = bestTime1.getTime();
        double bt2 = bestTime2.getTime();
        
        if (bt1 < bt2) {
            return -1;
        }
        else if (bt1 > bt2) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
