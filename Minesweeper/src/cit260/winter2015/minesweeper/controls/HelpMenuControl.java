/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.controls;

import java.io.Serializable;


/**
 *
 * @author Group
 */
public class HelpMenuControl  implements Serializable {

    public void displayHowToPlay() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println(
                "\tMinesweeper is a single-player puzzle game. A player has to "
                        + "\n\tclear a board containing hidden 'mines' without "
                        + "\n\tdetonating any of them. A list of rules for the game: "
                        + "\n\tUncover a mine, and the game ends. Uncover an empty "
                        + "\n\tsquare, and you keep playing. Uncover a number, and "
                        + "\n\tit tells you how many mines lay hidden in the eight "
                        + "\n\tsurrounding squares—information you use to deduce "
                        + "\n\twhich nearby squares are safe to click.");
        displayHelpBorder();
    }
        
    public void displayBasicStrategies() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\tThere are two basic patterns which combine to make all"
                         + "\n\tother patterns. The first is 1-1 and the second "
                         + "\n\tis 1-2. Whenever you see a 1-1 pattern starting from"
                         + "\n\tan edge (or where an open square functions as an "
                         + "\n\tedge) the 3rd square over is empty. This makes sense"
                         + "\n\tbecause the first 1 touches two squares, which must"
                         + "\n\tcontain the mine, while the second 1 also touches a"
                         + "\n\tthird square, which must be empty. Whenever you see"
                         + "\n\ta 1-2 pattern the 3rd square over is always a mine."
                         + "\n\tThis makes sense because the first 1 touches two"
                         + "\n\tsquares, which must contain the mine, while the 2"
                         + "\n\talso touches a third square, which must contain"
                         + "\n\tthe second mine. The two most famous patterns are"
                         + "\n\t1-2-1 and 1-2-2-1. These are so common new players"
                         + "\n\tshould memorize them immediately. If you look"
                         + "\n\tcarefully they are just combinations of the 1-2"
                         + "\n\tpattern. At first it seems like there are many "
                         + "\n\tpatterns. If you study them, they are actually 1-2-1"
                         + "\n\tand 1-2-2-1 patterns (or combinations of patterns)."
                         + "\n\tThese in turn are variations of the basic 1-1 and 1-2"
                         + "\n\tpatterns. Each set of numbers reduces when you subtract"
                         + "\n\tknown mines. Sometimes in Minesweeper you need to guess."
                         + "\n\tA typical case is a 50/50 situation where one mine"
                         + "\n\tis hidden in two squares. Guess quickly and move on."
                         + "\n\tThinking does not improve your chance of guessing "
                         + "\n\tcorrectly, it only wastes time. Waiting to see if you "
                         + "\n\tguessed right also wastes time, so assume you survived"
                         + "\n\tand try to keep playing. Do not delay taking forced"
                         + "\n\tguesses - solving the rest of the board first is a "
                         + "\n\twaste of time if you end up guessing the wrong square."
                    ); 
        displayHelpBorder();
    }
            
    public void displayAbout() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tThe developers of Minesweeper come from all over the world.\n" +
                "\n" +
                "\tНаталья Грей (Natalia Gray)\n" +
                "\tUfa, Russia\n" +
                "\n" +
                "\tAndres Reyes\n" +
                "\tGuayaquil, Ecuador\n" +
                "\n" +
                "\tAlfonso Ramirez\n" +
                "\tMonterrey, Mexico\n" +
                "\n" +
                "\tCheryl Rubenstein\n" +
                "\tNorth Dighton, Massachusetts \n" +
                "\n" +
                "\tKeith Banner\n" +
                "\tIdaho Falls, Idaho\n" +
                "\n" +
                "\tNikki Huntsman\n" +
                "\tIdaho Falls, Idaho"
                ); 
        displayHelpBorder();
    }
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
