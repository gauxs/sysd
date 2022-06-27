import java.util.*;

enum MatchFormat{
    ONEDAY, // each team plays one inning - 50 over limit
    TEST,   // each team plays two inning(s) - no limit on over
    T20     // each team plays one inning - 20 over limit
}

public class Match{
    String name;
    Team homeTeam;
    Team awayTeam;
    MatchFormat format;
    Integer currentInning;
    Vector<Inning> innings;

    Match(String name, 
            MatchFormat format,
            Team homeTeam, Team awayTeam){
        this.name = name;
        this.format = format;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        switch(format){
            case ONEDAY:
                // add one inning for each team
                // each inning will have 50 overs
                this.innings.add(new Inning(50));
                this.innings.add(new Inning(50));
            break;
            case T20:
            break;
            case TEST:
            break;
            default:
            // this case will not arise
        }
    }

    void toss(Team battingTeam, Team bowlingTeam){
        for(Inning inning: this.innings){
            inning.setBattingTeam(battingTeam);
            inning.setBowlingTeam(bowlingTeam); 

            // batting team becomes bowling team
            // in next inning
            Team temp = battingTeam;
            battingTeam = bowlingTeam;
            bowlingTeam = temp;
        }
    }

    void HandleEvent(Event event){
        Inning inning = this.innings.get(this.currentInning);

        if(inning.isInningFinished()){
            Integer previousInningRuns = inning.getTotalRunsScored();
            this.currentInning += 1;
            if(this.currentInning==innings.size()){
                // match over
                // declare winner
            }

            // innings over set target
            inning = this.innings.get(this.currentInning);
            inning.setRunTarget(previousInningRuns);
        }
    }
}
