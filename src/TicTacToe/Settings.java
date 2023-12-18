package TicTacToe;

import java.util.Scanner;

public class Settings {
    int sizeGameField;
    int min;
    int max;

    Settings (){
        this.min = 3;
        this.max = 5;
    }

    // Definiere Spielfeldgröße
    public int defineSizeOfGameField(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Wähle die Spielfeldgröße (3 für 3x3, 4 für 5x5 etc., min = "+ min + ", max = " + max +"): ");
        sizeGameField = sc.nextInt();

        if (sizeGameField < min || sizeGameField > max){
            int i = 0;
            while (i < 1){
                System.out.println("Spielfeldgröße außerhalb des Wertebereichs! Gib den Wert erneut ein: ");
                sizeGameField = sc.nextInt();
                if (sizeGameField >= min && sizeGameField <= max){
                    i++;
                }
            }
        }
        return sizeGameField;
    }

    // Spielregeln
    public void printRules(){
        System.out.println("***************************************************************************");
        System.out.println("Spielregeln:");
        System.out.println("Definiere die Spielfeldgröße.");
        System.out.println("Der Spieler der beginnt wählt sein Spielsymbol.");
        System.out.println("Um einen Spielzug zu setzen wähle zunächst die Zeile und dann die Spalte.");
        System.out.println("Viel Spaß :)");
        System.out.println("***************************************************************************");
        System.out.println(" ");
        System.out.println("Drücke s + Enter um das Spiel zu beginnen :) ");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.next();
        while (i < 1){
            if (s.equals("s")){
                System.out.println("Los geht´s :)");
                System.out.println(" ");
                i++;
            }
            if (!s.equals("s")){
                System.out.println("Ungültig - Wähle erneut");
                System.out.println(" ");
                s = sc.next();
            }
        }
    }
}
