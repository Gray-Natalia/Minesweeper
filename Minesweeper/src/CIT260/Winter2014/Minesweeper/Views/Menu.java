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
    
    public Menu() {
    }

    public Menu(String[][] menuItems) {
        this.menuItems = menuItems;
    }

    public String[][] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String[][] menuItems) {
        this.menuItems = menuItems;
    }
    
    public void display(String menuName) {
        System.out.println("\n\t===============================================================");
        System.out.println("\t" + menuName);
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
    
    private boolean validCommand(String command) {
        if(command == null) {
            return false;
        }
        else {
        return true;
        }
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