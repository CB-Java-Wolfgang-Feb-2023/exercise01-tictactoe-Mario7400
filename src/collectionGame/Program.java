package collectionGame;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //Festlegen der Spielfeldgröße + Objekt i für Input wird erstellt
        int minSizeField = 5;
        int maxSizeField = 15;
        Input i = new Input(minSizeField, maxSizeField);
        int rows = i.userInputRows();
        int columns = i.userInputColumns();


        //Anzahl der zu sammelten Items + Startposition Spieler
        int numOfItems = 8;
        int xPositionPlayer = 2;
        int yPositionPlayer = 2;

        //Objekte werden erstellt
        Field f = new Field(rows, columns);
        Player p = new Player(xPositionPlayer, yPositionPlayer, f);
        Items items = new Items(numOfItems, f);
        MovementSettings move = new MovementSettings(xPositionPlayer, yPositionPlayer, f);

        //Erzeugung Spielfeld
        f.buildField();
        p.setPlayer(f.getFieldGame());
        items.setItems(f.getFieldGame());

        //Spielschleife
        String decision;
        int loop = 0;
        Scanner sc = new Scanner(System.in);
        while (loop < 1){
            f.printField();
            System.out.println("Führe eine Aktion (g = vorwärts gehen, l = links drehen, r = rechts drehen, q = beenden) aus: ");
            decision = sc.next();

            switch (decision){
                case "g":
                    move.goForward(f.getFieldGame());
                    boolean win = move.winScenario(numOfItems);
                    if(win){
                        f.printField();
                        move.youWon(numOfItems);
                        loop = 1;
                    }
                    break;
                case "l":
                    move.rotateLeft(f.getFieldGame());
                    break;
                case "r":
                    move.rotateRight(f.getFieldGame());
                    break;
                case "q": loop = 1;
                    System.out.println("Programm wurde beendet!");break;
                default:
                    System.out.println("Falsche Taste gedrückt!"); break;
            }
        }
    }
}
