package lld.bowling_alley;

import java.util.Scanner;
import lld.bowling_alley.game.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bowling Alley 1.0");
        Game game = new Game(3);
        Scanner in = new Scanner(System.in);
        while (true) {
            switch (in.next()) {
                case "ADDPLR": {
                    game.addPlayer(in.next());
                    break;
                }
                case "PLAY": {
                    game.play();
                    break;
                }
                case "SCORE": {
                    game.scoreBoard();
                    break;
                }
                case "RANK": {
                    game.rank();
                }
            }
        }
    }
}
