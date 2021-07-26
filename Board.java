package goosegame;

import java.util.ArrayList;
import java.util.Scanner;

//lastIndexOf(String str)
//Returns the index within this string of the last occurrence of the specified substring.

//split(String regex)
//Splits this string around matches of the given regular expression.

/**
 *
 * @author Afro
 */
public class Board {
    private ArrayList<Player> players = new ArrayList<>();
    private String userCommand = "";
    
    public Board() {
        
    }
    
    public void initialize(){
        System.out.println("To add a player type \"add player <name>\".");
        System.out.println("You may add two or more players.");
        System.out.println("To start type \"start\".");
        Scanner scanner = new Scanner(System.in);
        
        do{
            userCommand = scanner.nextLine();

            if(userCommand.matches("add player [a-zA-Z]*")){
                String name;
                name = userCommand.replace("add player ", "");
                //System.out.println(name[1]);
                addPlayer(new Player(name));
                printPlayers();
            
            }else if(!userCommand.contains("start")){
                System.out.println("Please insert a valid command");
            }
        }while( !userCommand.contains("start") );
        
        // move Afro 6, 6
        System.out.println("To move a player type \"move <name> <1-6>, <1-6>\"");
        boolean someoneWon = false;
        do{
            userCommand = scanner.nextLine();
            if(userCommand.matches("move [a-zA-Z]* [1-6], [1-6]")){
                // takes the name from command
                String name = userCommand.replaceAll("[ ,1-6]", "").replaceAll("move", "");
                // takes the dice values from command
                String diceValues = userCommand.replaceAll("[a-zA-Z, ]", "");
                int dice1 = Integer.parseInt(diceValues.substring(0, 1));
                int dice2 = Integer.parseInt(diceValues.substring(1, 2));
                
                // search a player by name
                for (Player p : players) {
                    if(p.getName().equals(name)){
                        p.move(dice1, dice2);
                        someoneWon = p.checkWin();
                    }
                }
            }
        }while( !someoneWon );
    }
    
    public void addPlayer(Player player){
        boolean exist = false;
        for (Player p : players) {
            if(p.getName().equals(player.getName())){
                System.out.println(player.getName() + ": already existing player");
                exist = true;
            }
        }
        if(exist == false){
            players.add(player);
        }
    }
     
    public void printPlayers(){
        System.out.print("players: ");
        for (int i=0; i< players.size(); i++) {
            if(i!=0){
                System.out.print(", ");
            }
            System.out.print(players.get(i).getName());
             
        }
        System.out.println("");
    }
    
    public void move(String command){
        
    }
}
