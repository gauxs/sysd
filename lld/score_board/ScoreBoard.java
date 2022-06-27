import java.util.*;

class Score{
    // as a batsman
    Integer runScored;
    Integer ballsFaced;
    Integer numOfFours;
    Integer numOfSixes;
    // as a bowler
    Integer oversBalled;
    Integer wicketsTaken;
    Integer wideBalls;
    Integer NoBalls;
}

public class ScoreBoard{
    Player onStrike;
    Player notOnStrike;
    Player bowler;
    Integer totalScore;
    
    HashMap<Player, Score> board;

    Player getBowler(){
        return this.bowler;
    }

    Player getOnStrikeBatsman(){
        return this.onStrike;
    }

    void addScore(Integer run){

    }

    void addWicket(){

    }

    void newBowler(Player newBowler){

    }

    void newBatsman(Player newBatsman){

    }

    void swapBatsman(){

    }
}
