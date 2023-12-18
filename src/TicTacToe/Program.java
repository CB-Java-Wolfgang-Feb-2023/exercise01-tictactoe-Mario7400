package TicTacToe;

public class Program {
    public static void main(String[] args) {
        TicTacToe.Settings s = new Settings();
        s.printRules();
        int sizeSquareField = s.defineSizeOfGameField();

        TicTacToe.Field f = new Field(sizeSquareField);
        TicTacToe.Player p = new Player(f, sizeSquareField);

        f.buildArray();
        f.printArray();
        p.whoFirstX0();

        int loop = 0;
        while (loop<sizeSquareField*sizeSquareField){
            boolean endGame;
            p.playMove();
            f.printArray();
            p.counterSwitch();
            endGame = p.gameResult();
            if (endGame){
                loop = sizeSquareField*sizeSquareField;
            } else {
                loop++;
                if (loop == sizeSquareField*sizeSquareField){
                    p.gameFinished();
                }
            }
        }
    }
}
