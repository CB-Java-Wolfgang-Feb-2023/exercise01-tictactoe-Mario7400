package collectionGame;

import java.util.concurrent.ThreadLocalRandom;


public class Items {
    private int numOfItems;
    private int positionRows;
    private int positionColumns;

    Items(int numOfItems, Field field){
        this.numOfItems = numOfItems;
        field.getFieldGame();
    }

    private int generateRandomNumberRows(String[][] arr){
        return ThreadLocalRandom.current().nextInt(1, arr.length-1);
    }

    private int generateRandomNumberColumns(String[][] arr){
        return ThreadLocalRandom.current().nextInt(1, arr[0].length-1);
    }

    public void setItems(String[][] arr) {
        int i = 0;
        while (i < numOfItems) {
            positionRows = generateRandomNumberRows(arr);
            positionColumns = generateRandomNumberColumns(arr);

            proovementEmpytPlaceToSet(arr);
            arr[positionRows][positionColumns] = "*";
            i++;
        }
    }

    private void proovementEmpytPlaceToSet(String[][] arr){
        if (arr[positionRows][positionColumns].equals("*") || arr[positionRows][positionColumns].equals(">")) {
            int k = 0;
            while (k<1){
                positionRows = generateRandomNumberRows(arr);
                positionColumns = generateRandomNumberColumns(arr);
                if (!arr[positionRows][positionColumns].equals("*") && !arr[positionRows][positionColumns].equals(">")){
                    k++;
                }
            }
        }
    }












}
