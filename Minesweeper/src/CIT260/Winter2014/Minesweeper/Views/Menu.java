/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIT260.Winter2014.Minesweeper.Views;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author knban_000
 */
public abstract class Menu implements Serializable, ViewInterface {
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
    public String getCommand() {
        Scanner inFile = new Scanner(System.in);
        String command = inFile.nextLine();
        if(validCommand(command) == false) {
        }
        command = command.trim().toUpperCase();
        return command;
    }
    
    
}