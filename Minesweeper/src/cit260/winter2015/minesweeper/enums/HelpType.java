/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.enums;

/**
 *
 * @author knban_000
 */
public enum HelpType {
        HOW_TO_PLAY ("Minesweeper is a single-player puzzle game. A player has to "
                + "clear a board containing hidden 'mines' without "
                + "detonating any of them. A list of rules for the game: "
                + "Uncover a mine, and the game ends. Uncover an empty "
                + "square, and you keep playing. Uncover a number, and "
                + "it tells you how many mines lay hidden in the eight "
                + "surrounding squares—information you use to deduce "
                + "which nearby squares are safe to click."),
        
        BASIC_STRATEGIES ("There are two basic patterns which combine to make all"
                + "tother patterns. The first is 1-1 and the second "
                + "is 1-2. Whenever you see a 1-1 pattern starting from"
                + "an edge (or where an open square functions as an "
                + "edge) the 3rd square over is empty. This makes sense "
                + "because the first 1 touches two squares, which must "
                + "contain the mine, while the second 1 also touches a "
                + "third square, which must be empty. Whenever you see "
                + "a 1-2 pattern the 3rd square over is always a mine. "
                + "This makes sense because the first 1 touches two "
                + "squares, which must contain the mine, while the 2 "
                + "also touches a third square, which must contain "
                + "the second mine. The two most famous patterns are "
                + "1-2-1 and 1-2-2-1. These are so common new players "
                + "should memorize them immediately. If you look "
                + "carefully they are just combinations of the 1-2 "
                + "pattern. At first it seems like there are many "
                + "patterns. If you study them, they are actually 1-2-1 "
                + "and 1-2-2-1 patterns (or combinations of patterns). "
                + "These in turn are variations of the basic 1-1 and 1-2 "
                + "patterns. Each set of numbers reduces when you subtract "
                + "known mines. Sometimes in Minesweeper you need to guess. "
                + "A typical case is a 50/50 situation where one mine "
                + "tis hidden in two squares. Guess quickly and move on. "
                + "Thinking does not improve your chance of guessing "
                + "correctly, it only wastes time. Waiting to see if you "
                + "guessed right also wastes time, so assume you survived "
                + "and try to keep playing. Do not delay taking forced "
                + "guesses - solving the rest of the board first is a "
                + "waste of time if you end up guessing the wrong square. "),
          
        ABOUT ("The developers of Minesweeper come from all over the world."
                + "\n"
                + "\nНаталья Грей (Natalia Gray)"
                + "\nUfa, Russia"
                + "\n"
                + "\nAndres Reyes"
                + "\nGuayaquil, Ecuador"
                + "\n"
                + "\nAlfonso Ramirez"
                + "\nMonterrey, Mexico"
                + "\n"
                + "\nCheryl Rubenstein"
                + "\nNorth Dighton, Massachusetts"
                + "\n"
                + "\nKeith Banner"
                + "\nIdaho Falls, Idaho"
                + "\n"
                + "\nNikki Huntsman"
                + "\nIdaho Falls, Idaho");
        
        String helpText;

    private HelpType(String helpText) {
        this.helpText = helpText;
    }

    public String getHelpText() {
        return helpText;
    }
}
