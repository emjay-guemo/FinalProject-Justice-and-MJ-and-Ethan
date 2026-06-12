public class War extends CasinoGame {

    private Deck deck;
    private Player player;

    // Creates a new War game
    public War(Player player) {
        this.player = player;
        deck = new Deck();
    }

    @Override
    public boolean play() {

        deck.reset();

        Card playerCard = deck.dealCard();
        Card dealerCard = deck.dealCard();

        System.out.println("\n--- WAR ---");

        System.out.println("Your card: " + playerCard);
        System.out.println("Dealer's card: " + dealerCard);

        int playerValue = getWarValue(playerCard);
        int dealerValue = getWarValue(dealerCard);

        if (playerValue > dealerValue) {

            System.out.println("You Win!");

            return true;
        }

        else if (dealerValue > playerValue) {

            System.out.println("Dealer Wins!");

            return false;
        }

        else {

            return handleTie();
        }
    }

    // Handles what happens if both cards are equal
    private boolean handleTie() {

        System.out.println("\nWAR!");

        // Burn cards
        deck.dealCard();
        deck.dealCard();
        deck.dealCard();

        Card playerWarCard = deck.dealCard();

        deck.dealCard();
        deck.dealCard();
        deck.dealCard();

        Card dealerWarCard = deck.dealCard();

        System.out.println("War Card: " + playerWarCard);
        System.out.println("Dealer War Card: " + dealerWarCard);

        int playerValue = getWarValue(playerWarCard);
        int dealerValue = getWarValue(dealerWarCard);

        if (playerValue > dealerValue) {

            System.out.println("You won the war!");

            return true;
        }

        else if (dealerValue > playerValue) {

            System.out.println("Dealer won the war!");

            return false;
        }

        else {

            System.out.println("Double Tie! Dealer wins.");

            return false;
        }
    }

    // Converts card ranks into War values
    private int getWarValue(Card card) {

        String rank = card.getRank();

        if (rank.equals("Ace")) {
            return 14;
        }
        else if (rank.equals("King")) {
            return 13;
        }
        else if (rank.equals("Queen")) {
            return 12;
        }
        else if (rank.equals("Jack")) {
            return 11;
        }
        else {
            return Integer.parseInt(rank);
        }
    }
}