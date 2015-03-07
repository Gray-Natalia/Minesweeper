/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.Serializable;

/**
 *
 * @author Keith Banner
 */
public class GameMenuControl implements Serializable {

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
