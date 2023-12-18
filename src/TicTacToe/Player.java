package TicTacToe;

import java.util.Scanner;

public class Player {
    private int userInput;
    private int numSize;
    private int counter;
    private String[] playerSign;
    private String choosePlayerSymbol;
    private String[][] arr;

    private boolean quit;

    Player(Field f, int numSize){
        playerSign = new String[2];
        playerSign[0] = "x";
        playerSign[1] = "o";
        this.arr = f.getArr();

        this.counter = 0;
        this.quit = false;
        this.numSize = numSize;
    }

    // Spielerwahl
    public void whoFirstX0(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Wähle den ersten Spieler: x oder o: ");
        choosePlayerSymbol = sc.next();
        //counter = sc.nextInt();
        int i = 0;

        while (i < 1) {
            switch (choosePlayerSymbol) {
                case "x", "X" -> {
                    System.out.println("Spieler 1 hat das Symbol x");
                    System.out.println("Spieler 2 hat das Symbol o");
                    i++;
                    counter = 0;
                }
                case "o", "O" -> {
                    System.out.println("Spieler 1 hat das Symbol o");
                    System.out.println("Spieler 2 hat das Symbol x");
                    i++;
                    counter = 1;
                }
                default -> {
                    System.out.println("Ungültige Eingabe - wähle erneut: ");
                    choosePlayerSymbol = sc.next();
                }
            }
        }
    }

    //Spielzug
    public void playMove(){
        int posRows=0;
        int posColumns=0;
        int j = 0;
        while(j<1){
            Scanner sc = new Scanner(System.in);
            System.out.println("Wähle die Zeile 1 bis "+numSize);
            userInput = sc.nextInt();
            troubleshootingValueOutOfRange();
            posRows = userInput;

            System.out.println("Wähle die Spalte 1 bis "+numSize);
            userInput = sc.nextInt();
            troubleshootingValueOutOfRange();
            posColumns = userInput;

            if (arr[posRows-1][posColumns-1].equals("_")){
                j++;
            } else {
                System.out.println("Platz bereits belegt - wähle erneut!");
            }
        }
        String s = playerSign();
        arr[posRows-1][posColumns-1] = s;
    }

    // User Eingabe korrekt??
    private void troubleshootingValueOutOfRange(){
        Scanner sc = new Scanner(System.in);
        int i =0;
        if (userInput < 1 || userInput > numSize){
            while (i<1){
                System.out.println("Eingabe außerhalb des Spielfelds - Wähle erneut!");
                System.out.println("Wähle erneut einen Wert zwischen 1 bis "+ 4);
                userInput = sc.nextInt();
                if (userInput > 0 && userInput <= numSize){
                    i++;
                }
            }
        }
    }

    // Spielersymbol wird gesetzt
    private String playerSign(){
        String s;
        s = playerSign[counter];
        return s;
    }

    // counter switch --> Switched damit das Symbol
    public void counterSwitch(){
        if (counter == 0){
            counter = 1;
        } else if (counter == 1) {
            counter = 0;
        }
    }

    // Spielentscheidung
    public boolean gameResult(){
        gameDecisionDiagonal(0);
        gameDecisionDiagonal(1);
        gameDecisionRows(0);
        gameDecisionRows(1);
        gameDecisionColumns(0);
        gameDecisionColumns(1);
        return quit;
    }

    private void gameDecisionDiagonal(int dec){
        int numbX = 0;
        int numbX2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][i].equals(playerSign[dec])){
                numbX += 1;
                if (numbX == numSize){
                    System.out.println("Spieler " + playerSign[dec] + " hat gewonnen!");
                    quit = true;
                }
            }
            if(arr[arr.length-1-i][i].equals(playerSign[dec])){
                numbX2 += 1;
                if (numbX2 == numSize){
                    System.out.println("Spieler " + playerSign[dec] + " hat gewonnen!");
                    quit = true;
                }
            }
        }
    }

    private void gameDecisionRows(int dec){
        int numbRow = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j].equals(playerSign[dec])){
                    numbRow += 1;
                    if (numbRow == numSize){
                        System.out.println("Spieler " + playerSign[dec] + " hat gewonnen!");
                        quit = true;
                    }
                }
            }
            numbRow = 0;
        }
    }

    private void gameDecisionColumns(int dec){
        int numbCol = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j][i].equals(playerSign[dec])){
                    numbCol += 1;
                    if (numbCol == numSize){
                        System.out.println("Spieler " + playerSign[dec] + " hat gewonnen!");
                        quit = true;
                    }
                }
            }
            numbCol = 0;
        }
    }

    public void gameFinished(){
        System.out.println("Unentschieden! :)");
    }
}
