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
public class MineRandomizer {
    
    ChooseLevelMenuControl chooseLevelMenuControl = new ChooseLevelMenuControl();
    
    MineRandomizer[] mineLocation = new MineRandomizer[chooseLevelMenuControl.numberOfMines];
    
    public MineRandomizer() {
        for (int i = 0; i < chooseLevelMenuControl.numberOfMines; i++){
            mineLocation[i] = new MineRandomizer(
                    (char)('A' + (char) (Math.random() * chooseLevelMenuControl.numberOfColumns))
                    , 1+ (int) (Math.random() * chooseLevelMenuControl.numberOfRows));
            System.out.println("Array number " + i + "created");
            for (int j = 0; j < i; j++){                
                while (mineLocation[i].column == mineLocation[j].column && mineLocation[i].row == mineLocation[j].row) {
                    mineLocation[i] = new MineRandomizer(
                            (char)('A' + (char) (Math.random() * chooseLevelMenuControl.numberOfColumns))
                            , 1+ (int) (Math.random() * chooseLevelMenuControl.numberOfRows));
                }
            }
        }
        
    }
    
    char column;
    int row;
    
    public MineRandomizer(char col, int ro) {
        column = col;
        row = ro;
    }
}
