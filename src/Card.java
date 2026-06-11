public class Card {

    private String suit;
    private String rank;

    // Creates a card with a suit and a rank
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        }

    // Added getters for encapsulation: allows read-only access to suit, rank, and value.
    public String getSuit() {
        return suit;
    }

    public String getRank() {return rank;}

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}