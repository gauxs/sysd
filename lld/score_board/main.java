import java.util.*;



class Main {
    public static void main(String[] args) {
        // create Indian team
        Player virat = new Player("Virat", PlayerStrength.BATSMAN);
        Player pandya = new Player("Pandya", PlayerStrength.ALLROUNDER);
        Player ashwin = new Player("Ashwin", PlayerStrength.BOWLER);

        Team indianTeam = new Team("INDIA");
        indianTeam.addPlayer(virat);
        indianTeam.addPlayer(pandya);
        indianTeam.addPlayer(ashwin);
        indianTeam.setCaptain(virat);
        indianTeam.setViceCaptain(pandya);

        // create Pakistan team
        Player babar = new Player("Babar", PlayerStrength.BATSMAN);
        Player shahdab = new Player("Shahdab", PlayerStrength.ALLROUNDER);
        Player amir = new Player("Amir", PlayerStrength.BOWLER);

        Team pakistanTeam = new Team("PAKISTAN");
        pakistanTeam.addPlayer(babar);
        pakistanTeam.addPlayer(shahdab);
        pakistanTeam.addPlayer(amir);
        pakistanTeam.setCaptain(babar);
        pakistanTeam.setViceCaptain(amir);

        Match match = new Match("ICC One Day", MatchFormat.ONEDAY, indianTeam, pakistanTeam);
        match.toss(indianTeam, pakistanTeam);
    }
}
