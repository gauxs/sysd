package lld.bowling_alley.game;

import java.util.*;
import lld.bowling_alley.round.*;

public class Game {
    Integer curRound;
    Integer numOfRound;
    HashMap<String, List<Round>> playerRounds;

    public Game(Integer numOfRound) {
        this.curRound = 0;
        this.numOfRound = numOfRound;
        this.playerRounds = new HashMap<>();
    }

    public void addPlayer(String playerName) {
        List<Round> rounds = new ArrayList<>();
        for (int roundNo = 1; roundNo < this.numOfRound; roundNo++) {
            rounds.add(new Round());
        }
        rounds.add(new FinalRound());
        this.playerRounds.put(playerName, rounds);
    }

    public void play() {
        this.curRound += 1;
        System.out.println("Round " + this.curRound + " started: ");
        for (Map.Entry<String, List<Round>> entry : this.playerRounds.entrySet()) {
            System.out.println("Describe " + entry.getKey() + " performance: ");
            entry.getValue().get(this.curRound - 1).play();
        }
    }

    public void scoreBoard() {
        for (int roundNo = 1; roundNo <= this.curRound; roundNo++) {
            System.out.println("Round " + roundNo + " details: ");
            for (Map.Entry<String, List<Round>> entry : this.playerRounds.entrySet()) {
                System.out.println("Player " + entry.getKey() + ":");
                Round r = entry.getValue().get(roundNo - 1);
                System.out.print(r);
                System.out.print(" -> ");
                System.out.println((r.getTotalBonus() + r.getPinsDroppedTillNow()) + "(" + r.getTotalBonus() + "+"
                        + r.getPinsDroppedTillNow() + ")");
                System.out.println();
            }
        }
    }

    public void rank() {
        // TODO
    }
}
