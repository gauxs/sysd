package lld.bowling_alley.play;

import java.util.Scanner;

public class Play {
    private Integer bonus;
    private Integer playNumber;
    private Integer pinsToDrop;
    private Integer pinsDropped;

    public Play(Integer playNumber, Integer pinsToDrop) {
        this.bonus = 0;
        this.playNumber = playNumber;
        this.pinsToDrop = pinsToDrop;
        this.pinsDropped = 0;
    }

    public Integer getPinsDropped() {
        return this.pinsDropped;
    }

    public String toString() {
        if (this.pinsToDrop == this.pinsDropped) {
            if (this.playNumber == 1)
                return "X";
            else
                return "/";
        } else {
            return Integer.toString(this.pinsDropped);
        }
    }

    public Integer getBonus() {
        return this.bonus;
    }

    private void calculateBonus() {
        if (this.pinsToDrop == this.pinsDropped) {
            if (this.playNumber == 1)
                this.bonus = 10;
            else
                this.bonus = 5;
        }
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        System.out.println("Pins dropped in play " + this.playNumber + ": ");
        this.pinsDropped = in.nextInt();
        calculateBonus();
    }
}