/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.exceptions;

/**
 *
 * @author knban_000
 */
public class WinGameException extends Exception {
    private static final long serialVersionUID = 1L;

    public WinGameException() {
    }

    public WinGameException(String message) {
        super(message);
    }
    
}
