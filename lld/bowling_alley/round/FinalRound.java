package lld.bowling_alley.round;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lld.bowling_alley.play.Play;

public class FinalRound extends Round {
    List<Play> bonusPlays;

    public FinalRound() {
        this.bonusPlays = new ArrayList<>();
    }

    private void playBonus() {
        Integer playNumber = this.plays.size() + 1;
        Play p = new Play(playNumber, this.maxPins);
        p.play();
        this.pinsDroppedTillNow += p.getPinsDropped();
        this.totalBonus += p.getBonus();
        this.plays.add(p);

        Integer nextPlayPins = p.getPinsDropped();
        if (nextPlayPins != 10)
            nextPlayPins = this.maxPins - nextPlayPins;

        playNumber++;
        p = new Play(playNumber, nextPlayPins);
        p.play();
        this.pinsDroppedTillNow += p.getPinsDropped();
        this.totalBonus += p.getBonus();
        this.plays.add(p);
    }

    public void play() {
        Integer playNumber = 1;
        while (playNumber <= this.maxPlays) {
            Play p = new Play(playNumber, this.maxPins - this.pinsDroppedTillNow);
            p.play();
            this.pinsDroppedTillNow += p.getPinsDropped();
            this.totalBonus += p.getBonus();
            this.plays.add(p);

            if (this.pinsDroppedTillNow == this.maxPins)
                break;

            playNumber++;
        }

        if (this.totalBonus > 0) {
            this.playBonus();
        }
    }
}
