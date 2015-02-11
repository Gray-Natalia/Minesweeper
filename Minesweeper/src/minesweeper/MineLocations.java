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
public class MineLocations {
    
    int numberOfMines = 10;
    
    MineLocations[] mineLocation = new MineLocations[numberOfMines];
    
    public MineLocations() {
        mineLocation[1] = new MineLocations('A',5);
        mineLocation[2] = new MineLocations('C',2);
    }
    
    public char column;
    public int row;
    
    public MineLocations(char col, int ro) {
        column = col;
        row = ro;
    }
}
