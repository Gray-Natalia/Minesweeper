/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Collections;

/**
 *
 * @author knban_000
 */
public class test {
    
    public static void main(String args[]) {
        CellManager cm = new CellManager();
        MineManager mm = new MineManager();
        mm.presetMines();
        cm.calculateCellValues(9, 9, 10);
        
        int index;
    }
}
