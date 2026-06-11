import java.util.HashMap;

public class Poker extends CasinoGame implements Playable {

    // Private fields for poker game
    private Deck deck;
    private Hand playerHand;
    private Hand computerHand;


    public Poker() {
        deck = new Deck();
        playerHand = new Hand();
        computerHand = new Hand();
    }

    @Override
    public boolean play() {

        playerHand.clearCards();
        computerHand.clearCards();

        deck.reset();

        for (int i = 0; i < 5; i++) {
            playerHand.addCard(deck.dealCard());
            computerHand.addCard(deck.dealCard());
        }

        System.out.println("Your Hand:");
        System.out.println(playerHand);

        System.out.println();
        System.out.println("Computer Hand:");
        System.out.println(computerHand);

        int playerScore = scoreHand(playerHand);
        int computerScore = scoreHand(computerHand);

        System.out.println();
        System.out.println("Your Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore);

        // Decide winner
        if (playerScore > computerScore) {
            System.out.println("You Win!");
            return true;
        }
        else if (computerScore > playerScore) {
            System.out.println("Computer Wins!");
            return false;
        }
        else {
            System.out.println("Tie Game!");
            return false; // treat tie as loss (simple rule)
        }
    }

    // Counts matching card ranks and assigns points
    private int scoreHand(Hand hand) {

        // Stores how many times each rank appears
        HashMap<String, Integer> counts = new HashMap<>();

        for (Card card : hand.getCards()) {

            String rank = card.getRank();

            if (counts.containsKey(rank)) {
                counts.put(rank, counts.get(rank) + 1);
            }
            else {
                counts.put(rank, 1);
            }
        }

        int score = 0;

        for (int count : counts.values()) {

            if (count == 2) {
                score += 2;      // pair
            }
            else if (count == 3) {
                score += 6;      // three of a kind
            }
            else if (count == 4) {
                score += 12;     // four of a kind
            }
        }

        return score;
    }
}
