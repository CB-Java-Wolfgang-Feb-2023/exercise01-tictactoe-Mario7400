package collectionGame;

public class MovementSettings {
    private int xPositionPlayer;
    private int yPositionPlayer;
    private int counter;
    private String[] playerSign;
    private int itemCounter;


    MovementSettings(int xPositionPlayer, int yPositionPlayer, Field f){
        this.xPositionPlayer = xPositionPlayer;
        this.yPositionPlayer = yPositionPlayer;
        playerSign = new String[4];
        playerSign[0] = "^";
        playerSign[1] = ">";
        playerSign[2] = "˅";
        playerSign[3] = "<";

        this.counter = 1;

        f.getFieldGame();
    }


    //r --> rotate right
    //l --> rotate left
    //g --> go forward
    //q --> quit

    public void rotateRight(String[][] arr){
        if(counter == 0){
            counter = 1;
        } else if (counter == 1) {
            counter = 2;
        } else if (counter == 2) {
            counter = 3;
        } else if (counter == 3) {
            counter = 0;
        }
        arr[xPositionPlayer][yPositionPlayer] = playerSign[counter];
    }


    public void rotateLeft(String[][] arr){
        if(counter == 0){
            counter = 3;
        } else if (counter == 1) {
            counter = 0;
        } else if (counter == 2) {
            counter = 1;
        } else if (counter == 3) {
            counter = 2;
        }
        arr[xPositionPlayer][yPositionPlayer] = playerSign[counter];
    }


    public void goForward(String[][] arr){
        arr[xPositionPlayer][yPositionPlayer] = " "; //löschen der aktuellen Position

        if(counter == 0 && !arr[xPositionPlayer-1][yPositionPlayer].equals("#")){
            if (arr[xPositionPlayer-1][yPositionPlayer].equals("*")){
                itemCounter++;
            }
            arr[xPositionPlayer-1][yPositionPlayer] = playerSign[counter];
            xPositionPlayer -= 1; //Aktualisieren der aktuellen Position
        }

        else if (counter == 2 && !arr[xPositionPlayer+1][yPositionPlayer].equals("#")) {
            if (arr[xPositionPlayer+1][yPositionPlayer].equals("*")){
                itemCounter++;
            }
            arr[xPositionPlayer+1][yPositionPlayer] = playerSign[counter];
            xPositionPlayer += 1;
        }

        else if (counter == 1 && !arr[xPositionPlayer][yPositionPlayer+1].equals("#")) {
            if (arr[xPositionPlayer][yPositionPlayer+1].equals("*")){
                itemCounter++;
            }
            arr[xPositionPlayer][yPositionPlayer+1] = playerSign[counter];
            yPositionPlayer += 1;
        }

        else if (counter == 3 && !arr[xPositionPlayer][yPositionPlayer-1].equals("#")) {
            if (arr[xPositionPlayer][yPositionPlayer-1].equals("*")){
                itemCounter++;
            }
            arr[xPositionPlayer][yPositionPlayer-1] = playerSign[counter];
            yPositionPlayer -= 1;
        }

        else {
            System.out.println("Fehler in der Bewegung ...");
            System.out.println("Schritt nach vorne nicht möglich!!!");
            System.out.println(" ");
            arr[xPositionPlayer][yPositionPlayer] = playerSign[counter]; //falls eine Bewegung nicht möglich ist weil der Spieler an der Wand steht --> Spielsymbol wird wieder hergestellt
        }
    }

    public boolean winScenario(int numOfItems){
        boolean quit = false;
        if (itemCounter == numOfItems){
            quit = true;
            System.out.println(" ");
        }
        return quit;
    }

    public void youWon(int numOfItems){
        System.out.println("Gewonnen! Du hast alle " +numOfItems+ " Items gesammelt! Spiel wurde beendet! :)");
    }


}
