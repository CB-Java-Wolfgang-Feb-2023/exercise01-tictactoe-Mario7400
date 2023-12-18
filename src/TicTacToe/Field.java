package TicTacToe;

public class Field {
    private String[][] arr;


    Field(int numSize){
        this.arr = new String[numSize][numSize];
    }


    public void buildArray(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "_";
            }
        }
    }


    public void printArray(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j<arr[i].length-1){
                    System.out.print("|");
                }
            }
            System.out.println(" ");
        }
    }


    public String[][] getArr() {
        return arr;
    }
}
