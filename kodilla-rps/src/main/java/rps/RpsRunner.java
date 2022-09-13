package rps;

public class RpsRunner {
    public static void main(String[] args) {
        RockPaperScissorsGame rockPaperScissorsGame = new RockPaperScissorsGame();
        rockPaperScissorsGame.initialize();
        rockPaperScissorsGame.play();
    }
}
