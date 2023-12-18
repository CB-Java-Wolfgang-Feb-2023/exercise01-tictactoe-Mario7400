package collectionGame;

public class Field {
    private String[][] fieldGame;

    Field (int rows, int columns){
        this.fieldGame = new String[rows][columns];
    }

    private void buildFieldSides (){
        for (int i = 0; i < fieldGame.length; i++) {
            fieldGame[i][0] = "#";
            fieldGame[i][fieldGame[i].length-1] = "#";
            for (int j = 1; j < fieldGame[i].length-1; j++) {
                fieldGame[i][j] = " ";
            }
        }
    }

    private void buildFieldAboveBelow(){
        for (int i = 1; i < fieldGame[0].length-1; i++) {
            fieldGame[0][i] = "#";
            fieldGame[fieldGame.length-1][i] = "#";
        }
    }

    public void buildField () {
        buildFieldSides();
        buildFieldAboveBelow();
    }

    public void printField () {
        for (int i = 0; i < fieldGame.length; i++) {
            for (int j = 0; j < fieldGame[i].length; j++) {
                System.out.print(fieldGame[i][j]);
            }
            System.out.println(" ");
        }
    }

    public String[][] getFieldGame() {
        return fieldGame;
    }
}
