public class Card {

    private String suit;
    private String rank;
    private int value;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;


        switch (rank) {
            case "Ace":
                value = 1;
                break;

            case "King":
            case "Queen":
            case "Jack":
                value = 10;
                break;

            default:
                value = Integer.parseInt(rank);
                break;
        }
    }

    // Added getters for encapsulation: allows read-only access to suit, rank, and value.
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}