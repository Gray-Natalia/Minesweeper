/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.menuViews;

import cit260.winter2015.minesweeper.interfaces.EnterInfo;
import cit260.winter2015.minesweeper.interfaces.ViewInterface;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author knban_000
 */
public abstract class Menu implements Serializable, ViewInterface, EnterInfo {

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
    
    @Override
    public String getInput() {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        command = command.trim().toUpperCase();
        return command;
    }
}
