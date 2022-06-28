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
    Integer noBalls;

    Score(){
        this.runScored = 0;
        this.ballsFaced = 0;
        this.numOfFours = 0;
        this.numOfSixes = 0;
        this.oversBalled = 0;
        this.wicketsTaken = 0;
        this.wideBalls = 0;
        this.noBalls = 0;
    }
}

public class ScoreBoard{
    Integer totalScore;
    HashMap<Player, Score> board;

    ScoreBoard(){
        this.totalScore = 0;
        this.board = new HashMap<>();
    }

    void addScore(Player batsman){
        Score score = this.board.getOrDefault(batsman, new Score());

    }

    void addWicket(Player bowler){

    }
}
