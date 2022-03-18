package lld.bowling_alley.round;

import java.util.ArrayList;
import java.util.List;

import lld.bowling_alley.play.*;

public class Round {
    Integer maxPins;
    Integer maxPlays;
    Integer bonus;
    Integer pinsDroppedTillNow;
    List<Play> plays;

    public Round() {
        this.maxPins = 10;
        this.maxPlays = 2;
        this.bonus = 0;
        this.pinsDroppedTillNow = 0;
        this.plays = new ArrayList<>();
    }

    public Integer getPinsDroppedTillNow() {
        return this.pinsDroppedTillNow;
    }

    public Integer getTotalBonus() {
        return this.bonus;
    }

    public void play() {
        Integer playNumber = 1;
        while (playNumber <= this.maxPlays) {
            Play p = new Play(playNumber, this.maxPins - this.pinsDroppedTillNow);
            p.play();
            this.pinsDroppedTillNow += p.getPinsDropped();
            this.bonus += p.getBonus();
            this.plays.add(p);

            if (this.pinsDroppedTillNow == this.maxPins)
                break;

            playNumber++;
        }
    }

    public String toString() {
        String ret = "Round details: [";
        for (Integer playNo = 0; playNo < this.plays.size(); playNo++) {
            ret += this.plays.get(playNo).toString() + ", ";
        }
        ret += "]";
        return ret;
    }
}