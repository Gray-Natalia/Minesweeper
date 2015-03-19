/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper;

/**
 *
 * @author Keith
 */

import java.io.Serializable;

public class BestTime implements Serializable, Comparable<BestTime> {
    
    private String playerName;
    private double time;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public BestTime() {
    }

    public BestTime(String playerName, double time) {
        this.playerName = playerName;
        this.time = time;
    }
    
    @Override
    public int compareTo(BestTime bestTime1) {
        return ((Double) (bestTime1.getTime())).compareTo(getTime());
    }

    @Override
    public String toString() {
        return "BestTime{" + "playerName=" + playerName + ", time=" + time + '}';
    }
}

