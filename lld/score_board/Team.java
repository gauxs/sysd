import java.util.*;

public class Team{
    String name;
    Player captain;
    Player viceCaptain;
    Vector<Player> players;

    Team(String name){
        this.name = name;
        this.players = new Vector<>();
    }

    void addPlayer(Player player){
        this.players.add(player);
    }

    void setCaptain(Player player){
        this.captain = player;
    }

    void setViceCaptain(Player player){
        this.viceCaptain = player;
    }
}
