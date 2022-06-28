import java.util.*;

enum Event{
    RUN_1,
    RUN_2,
    RUN_3,
    RUN_4,
    BOUNDARY_4,
    BOUNDARY_6,
    NO_BALL, 
    WIDE_BALL,
    OUT
}

class Ball{
    Player bowler;
    Player batsman;
    Integer runsScored;
    Event event;

    Ball(Player batsman, Player bowler, Event event){
        this.bowler = bowler;
        this.batsman = batsman;
        this.event = event;
        switch(event){
            case RUN_1:
            this.runsScored = 1;
            break;
            case RUN_2:
            this.runsScored = 2;
            break;
            case RUN_3:
            this.runsScored = 3;
            break;
            case RUN_4:
            this.runsScored = 4;
            break;
            case BOUNDARY_4:
            this.runsScored = 4;
            break;
            case BOUNDARY_6:
            this.runsScored = 6;
            break;
            case NO_BALL:
            this.runsScored = 1;
            break;
            case WIDE_BALL:
            this.runsScored = 1;
            break;
        }
    }

    Integer getRunScored(){
        return this.runsScored;
    }
}

class Over{
    Integer totalRuns;
    Integer totalBallsAllowed;
    Integer totalBallsBowled;
    Vector<Ball> balls;

    Over(){
        this.totalRuns = 0;
        // this can incease for no balls etc
        this.totalBallsAllowed = 6;
        this.totalBallsBowled = 0;
        this.balls = new Vector<>();
    }

    Boolean isOverFinished(){
        return this.totalBallsBowled==this.totalBallsAllowed;
    }

    void addBall(Ball ball){
        this.totalRuns += ball.runsScored;
        if(ball.event.equals(Event.NO_BALL) || ball.event.equals(Event.WIDE_BALL))
            this.totalBallsAllowed += 1;
        this.balls.add(ball);
    }
}

public class Inning{
    Integer totalOvers;
    Integer currentOver;
    Integer runTarget;
    Vector<Over> overs;
    Team battingTeam;
    Team bowlingTeam;

    ScoreBoard board;
    // this will be defined from external systems
    // but is randomly defined for demo purposes
    Integer onStrikeBatsman;
    Integer otherBatsman;
    Vector<Player> battingOrder;
    // this will be defined from external systems
    // but is randomly defined for demo purposes
    Integer curBowler;
    Vector<Player> bowlingOrder;

    Inning(Integer totalOvers){
        this.totalOvers = totalOvers;
        this.currentOver = 0;
        this.overs = new Vector<>();
        for(int i = 0; i < totalOvers; i++)
            this.overs.add(i, new Over());
        this.battingTeam = null;
        this.bowlingTeam = null;
        this.runTarget = Integer.MAX_VALUE;
    }

    Boolean isInningFinished(){
        return this.currentOver>this.totalOvers || this.onStrikeBatsman==-1 || this.otherBatsman==-1;
    }

    void setBattingTeam(Team team){
        this.battingTeam = team;
        // player insert order becomes the batting order
        this.battingOrder = this.battingTeam.players;
        this.onStrikeBatsman = 0;
        this.otherBatsman = 1;
    }

    void setBowlingTeam(Team team){
        this.bowlingTeam = team;
        // player insert order becomes the batting order
        // and are picked in round robin fashion
        this.bowlingOrder = this.bowlingTeam.players;
        this.curBowler = 0;
    }

    void setRunTarget(Integer runTarget){
        this.runTarget = runTarget;
    }

    Integer getTotalRunsScored(){
        return 0;
    }

    void swap(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }

    void handleEvent(Event event){
        Over curOver = this.overs.get(this.currentOver);
        Player onStrikePlayer = this.battingOrder.get(this.onStrikeBatsman);
        Player bowler = this.bowlingOrder.get(this.curBowler);

        // create a ball
        Ball ball = new Ball(onStrikePlayer, bowler, event);
        curOver.addBall(ball);

        switch(event){
            case OUT:
            // change onstrike batsman
            // if not more player inning finished
            break;
            case RUN_1:
            swap(this.onStrikeBatsman, this.otherBatsman);
            break;
            case RUN_3:
            swap(this.onStrikeBatsman, this.otherBatsman);
            break;
        }    

        if(curOver.isOverFinished()){
            this.currentOver += 1;
            if(this.currentOver>this.totalOvers){
                return;
            }else{
                // change bowler
                this.curBowler = (this.curBowler + 1)%this.bowlingOrder.size();
                // change onstrike batsman
                swap(this.onStrikeBatsman, this.otherBatsman);
            }
        }
    }
}
