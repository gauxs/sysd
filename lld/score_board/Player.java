enum PlayerStrength{
    BATSMAN,
    BOWLER,
    ALLROUNDER
}

public class Player{
    String name;
    PlayerStrength strength;

    Player(String name, PlayerStrength strength){
        this.name = name;
        this.strength = strength;
    }
}
