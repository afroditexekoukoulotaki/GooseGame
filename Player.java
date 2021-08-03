package goosegame;

/**
 *
 * @author Afro
 */
public class Player {
    private String name;
    private int currentSpace;

    public Player() {
        this.name = "";
    }

    public Player(String name) {
        this.name = name;
        this.currentSpace = 0;
    }

    public String getName() {
        return name;
    }

    public void setCurrentSpace(int currentSpace) {
        this.currentSpace = currentSpace;
    }

    public int getCurrentSpace() {
        return currentSpace;
    }
    // Pippo rolls 4, 2. Pippo moves from Start to 6
    void move(int dice1, int dice2){
        if( this.currentSpace == 0){
            System.out.print(this.name + " rolls " + dice1 + ", " + dice2 + ". " + 
                    this.name + " moves from Start to ");
        }else {
            System.out.print(this.name + " rolls " + dice1 + ", " + dice2 + ". " + 
                    this.name + " moves from " + this.currentSpace + " to ");
        }
        this.currentSpace += dice1;
        this.currentSpace += dice2;
        if( this.currentSpace > 63){
            this.currentSpace = 63 - (this.currentSpace - 63);
            System.out.println("63. " + this.name + " bounces! " + this.name + " returns to " + this.currentSpace);
        }else{
            System.out.println(this.currentSpace);
        }
    }
    
    public boolean checkWin(){
        if(this.currentSpace == 63){
            System.out.println(this.name + " Wins!");
            return true;
        }else
            return false;
    }
    
    @Override
    public String toString(){
        return this.name + " " + this.currentSpace;
    }
}

// test