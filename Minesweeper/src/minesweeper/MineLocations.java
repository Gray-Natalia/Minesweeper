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
        mineLocation[0] = new MineLocations('A',5);
        mineLocation[1] = new MineLocations('B',2);
        mineLocation[2] = new MineLocations('C',7);
        mineLocation[3] = new MineLocations('D',3);
        mineLocation[4] = new MineLocations('E',6);
        mineLocation[5] = new MineLocations('F',8);
        mineLocation[6] = new MineLocations('G',1);
        mineLocation[7] = new MineLocations('H',9);
        mineLocation[8] = new MineLocations('I',4);
        mineLocation[9] = new MineLocations('C',2);
    }
    
    public char column;
    public int row;
    
    public MineLocations(char col, int ro) {
        column = col;
        row = ro;
    }
}
