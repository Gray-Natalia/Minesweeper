/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.views;

import cit260.winter2015.minesweeper.exceptions.MenuException;
import cit260.winter2015.minesweeper.interfaces.DisplayInfo;
import cit260.winter2015.minesweeper.interfaces.EnterInfo;
import cit260.winter2015.minesweeper.interfaces.ViewInterface;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author knban_000
 */
public abstract class Menu implements Serializable, ViewInterface, DisplayInfo, EnterInfo {
    private static final long serialVersionUID = 1L;
    
    private String[][] menuItems = null;
    protected final String menuName;
    
    public Menu() {
        menuName = "Menu";
    }

    public Menu(String menu, String[][] menuItems) {
        menuName = menu;
        this.menuItems = menuItems;
    }

    public String[][] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String[][] menuItems) {
        this.menuItems = menuItems;
    }
    
    @Override
    public void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\t" + menuName);
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (String[] menuItem : menuItems) {
            System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
        }
        System.out.println("\t===============================================================\n");
    }
    
    private boolean validCommand(String command) {
        return command != null;
    }
    
    @Override
    public String getInput() throws MenuException{
        Scanner in = new Scanner(System.in);
        String command = null;
        try {
            command = in.nextLine();
            if(command.length() < 1) {
                throw new MenuException();
            }
        } catch (MenuException e) {
            System.err.println("No input detected. Please try again.");
            in.next();
        } finally {
            command = command.trim().toUpperCase();
            return command;
        }
    }
    
    
}