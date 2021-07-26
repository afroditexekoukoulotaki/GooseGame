package goosegame;

import java.util.Scanner;

/**
 *
 * @author Afro
 */
public class GooseGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String str = "move Afro 5, 4";
        //System.out.println(str.matches("move [a-zA-Z]* [1-6], [1-6]"));
        
        //System.out.println("-->" + str.replaceAll("[ ,1-6]", ""));
        
        //System.out.println(str.replaceAll("[a-zA-Z, ]", ""));
        //String str2 = str.replaceAll("[a-zA-Z, ]", "");
        //System.out.println(str2.substring(0, 1));
        //Integer.parseInt(str)
        
        Board board = new Board();
        board.initialize();
    }
    
}
