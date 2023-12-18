package collectionGame;

public class Player {
    private int xPositionPlayer;
    private int yPositionPlayer;

    Player(int xPositionPlayer, int yPositionPlayer, Field f){
        this.xPositionPlayer = xPositionPlayer;
        this.yPositionPlayer = yPositionPlayer;
        f.getFieldGame();
    }

    public void setPlayer(String[][] arr){
        arr[xPositionPlayer][yPositionPlayer] = ">";
    }
}
