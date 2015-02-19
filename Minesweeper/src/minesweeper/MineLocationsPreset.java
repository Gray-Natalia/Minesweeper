/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author knban_000
 */
public class MineLocationsPreset {
    int numberOfMines = 10;
    
    MineLocationsPreset[] mineLocation = new MineLocationsPreset[numberOfMines];
    
    public MineLocationsPreset() {
            mineLocation[0] = new MineLocationsPreset('A',2);
            mineLocation[1] = new MineLocationsPreset('C',2);
            mineLocation[2] = new MineLocationsPreset('D',9);
            mineLocation[3] = new MineLocationsPreset('G',5);
            mineLocation[4] = new MineLocationsPreset('F',3);
            mineLocation[5] = new MineLocationsPreset('G',2);
            mineLocation[6] = new MineLocationsPreset('E',8);
            mineLocation[7] = new MineLocationsPreset('E',7);
            mineLocation[8] = new MineLocationsPreset('H',7);
            mineLocation[9] = new MineLocationsPreset('G',4);
    }
    
    public char column;
    public int row;
    
    public MineLocationsPreset(char col, int ro) {
        column = col;
        row = ro;
    }
}
