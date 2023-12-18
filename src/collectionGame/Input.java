package collectionGame;

import java.util.Scanner;

public class Input {
    private int valueMinimumRowsColumns;
    private int valueMaximumRowsColumns;

    Input(int valueMinimumRowsColumns, int valueMaximumRowsColumns){
        this.valueMinimumRowsColumns = valueMinimumRowsColumns;
        this.valueMaximumRowsColumns = valueMaximumRowsColumns;
    }

    public int userInputRows(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib die Anzahl der Reihen ein (minimum " + valueMinimumRowsColumns +", maximum "+valueMaximumRowsColumns+"): ");
        int row = sc.nextInt();
        while (row < valueMinimumRowsColumns || row > valueMaximumRowsColumns){
            System.out.println("Eingabe ungültig - Gib den Wert erneut ein: ");
            row = sc.nextInt();
        }
        return row;
    }

    public int userInputColumns(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib die Anzahl der Spalten ein (minimum " + valueMinimumRowsColumns +", maximum "+valueMaximumRowsColumns+"): ");
        int column = sc.nextInt();
        while (column < valueMinimumRowsColumns || column > valueMaximumRowsColumns){
            System.out.println("Eingabe ungültig - Gib den Wert erneut ein: ");
            column = sc.nextInt();
        }
        return column;
    }





}
