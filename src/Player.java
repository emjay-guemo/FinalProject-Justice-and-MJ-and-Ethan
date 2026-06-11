// Represents a player in the game.
// Stores the player's name, hand, and chips.

public class Player {

    private String name;
    private Hand hand;
    private int chips;

    // Creates a player with the given name and a starting balance of $1000
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.chips = 1000;
    }

    // Returns the player's name
    public String getName() {
        return name;
    }

    // Returns the player's hand
    public Hand getHand() {
        return hand;
    }

    // Returns current balance
    public int getChips() {
        return chips;
    }

    // Adds winnings to balance
    public void addChips(int amount) {
        chips += amount;
    }

    // Removes chips after a loss
    public void removeChips(int amount) {
        chips -= amount;
    }

}
