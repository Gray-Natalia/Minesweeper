/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.enums;

/**
 *
 * @author Keith
 */

// States 0 empty, 1-8 numbers, 9 undiscovered, 10 flagged, 11 unknown
    // Game end only: 12 clicked exploded, 13 undiscovered mine, 14 Incorrect Flag, 15 discovered mine.
public enum CellStates {
    EMPTY(0),UNDISCOVERED(9),FLAGGED(10),UNKNOWN(11)
    ,EXPLODED(12),UNDISCOVERED_MINE(13),INCORRECT_FLAG(14),DISCOVERED_MINE(15);
    
    private final int state;

    public int getState() {
        return state;
    }
    
    CellStates(int state) {
        this.state = state;
    }
}
