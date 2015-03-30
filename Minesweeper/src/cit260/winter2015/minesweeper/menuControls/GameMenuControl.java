/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.menuControls;

import java.io.Serializable;
import cit260.winter2015.minesweeper.CellManager;
import cit260.winter2015.minesweeper.exceptions.EndGameException;

/**
 *
 * @author Keith Banner
 */
public class GameMenuControl implements Serializable {
    private static final long serialVersionUID = 1L;

    public GameMenuControl() {
    }

    public static void click() throws EndGameException {
        CellManager cm = new CellManager();
        cm.click();
    }

    public static void rightClick() {
        CellManager cm = new CellManager();
        cm.rightClick();
    }
    
    public static void twoButtonClick() throws EndGameException {
        CellManager cm = new CellManager();
        cm.twoButtonClick();
    }
}
