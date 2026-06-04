import java.util.ArrayList;

// Represents a player in the game.
// Stores the player's name, hand, and chips.

public class Player {

    private String name;
    private Hand hand;
    private int chips;


    // Creates a player with the given name.
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.chips = 0;
    }

    public Hand getHand() {
        return hand;
    }
}
