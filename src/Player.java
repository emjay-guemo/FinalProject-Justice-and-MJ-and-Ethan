import java.util.ArrayList;

// Represents a player in the game.
// Stores the player's name, hand and number of points.

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int numPoints;


    // Creates a player with the given name.
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.numPoints = 0;
    }


}
