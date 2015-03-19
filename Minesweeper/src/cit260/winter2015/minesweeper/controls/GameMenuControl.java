/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.controls;

import java.io.Serializable;
import cit260.winter2015.minesweeper.CellManager;

/**
 *
 * @author Keith Banner
 */
public class GameMenuControl implements Serializable {
    private static final long serialVersionUID = 1L;

    public GameMenuControl() {
    }

    public static void reveal() {
        CellManager cm = new CellManager();
        cm.clickReveal();
    }

    public static void flag() {
        CellManager cm = new CellManager();
        cm.clickFlag();
    }

    public static void unknown() {
        CellManager cm = new CellManager();
        cm.clickUnknown();
    }

}
