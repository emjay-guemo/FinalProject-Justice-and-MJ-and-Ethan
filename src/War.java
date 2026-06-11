public class War extends CasinoGame {
    private Deck deck;
    private double currentBet;
    private double balance; // Tracks the money

    // Sets up the game, deck, and gives player starting chips
    public War() {
        this.deck = new Deck();
        this.balance = 500.00; // Starts the player with $500
    }

    // Runs the Casino War game loop
    public void play() {
        System.out.println("\n--- Welcome to Casino War ---");

        while (balance > 0) {
            System.out.println("\nYour current balance: $" + balance);

            // Asks for a bet or checks if wanting to exit
            double betAmount = Input.getUserDouble("Enter bet amount (or 0 to return to main menu): $");

            if (betAmount == 0) {
                System.out.println("Returning to the main casino floor...");
                return; // Exits play and goes back to the main menu
            }
            if (betAmount < 0) {
                System.out.println("Bet must be a positive number!");
                continue; // Restarts loop to ask for a valid bet
            }
            if (betAmount > balance) {
                System.out.println("You do not have enough money for that bet!");
                continue;
            }

            // Bet accepted, start the round
            this.currentBet = betAmount;
            this.balance = this.balance - betAmount; // Takes the bet chips away

            // Deals the first two cards
            Card playerCard = deck.dealCard();
            Card dealerCard = deck.dealCard();

            System.out.println("\nYour card:     " + playerCard.toString());
            System.out.println("Dealer's card: " + dealerCard.toString());

            // Converts the card ranks to numbers for War
            int playerValue = getWarValue(playerCard);
            int dealerValue = getWarValue(dealerCard);

            // Compares the cards
            if (playerValue > dealerValue) {
                // If Player wins, gets bet back plus equal winnings times two
                this.balance = this.balance + (currentBet * 2);
                System.out.println("You win! You won: $" + currentBet);
            }
            else if (dealerValue > playerValue) {
                System.out.println("Dealer wins. You lost: $" + currentBet);
            }
            else {
                // It's a Tie
                handleTie();
            }
        }

        System.out.println("\nYou ran out of money! Game Over.");
    }

    // This is what happens during a Tie
    private void handleTie() {
        System.out.println("\nIt's a TIE!");
        System.out.println("1. Go to War (Double your bet)");
        System.out.println("2. Surrender (Lose half your bet)");

        int choice = Input.getUserInt("Your choice (1 or 2): ");

        if (choice == 2) {
            // if you surrender you give back half the bet
            double refund = currentBet / 2;
            this.balance = this.balance + refund;
            System.out.println("You surrendered. You got back: $" + refund);
        }
        else {
            // Checks if player can afford to double up or not
            if (currentBet > balance) {
                System.out.println("Not enough money to go to war, Forced to surrender.");
                this.balance = this.balance + (currentBet / 2);
                return;
            }

            // Takes the matching war bet money away
            this.balance = this.balance - currentBet;
            System.out.println("Going to war, Matching bet has been placed.");

            // Burns 3 cards and draws the 4th
            deck.dealCard(); deck.dealCard(); deck.dealCard();
            Card playerWarCard = deck.dealCard();

            deck.dealCard(); deck.dealCard(); deck.dealCard();
            Card dealerWarCard = deck.dealCard();

            System.out.println("\nWar - Your card:     " + playerWarCard.toString());
            System.out.println("War - Dealer's card: " + dealerWarCard.toString());

            int pWarValue = getWarValue(playerWarCard);
            int dWarValue = getWarValue(dealerWarCard);

            if (pWarValue > dWarValue) {
                // Player wins the war, Gives back all bet money + profit
                this.balance = this.balance + (currentBet * 3);
                System.out.println("You won, Profit: $" + currentBet);
            }
            else if (dWarValue > pWarValue) {
                System.out.println("You lost");
            }
            else {
                // Double Tie
                this.balance = this.balance + (currentBet * 4);
                System.out.println("Double Tie!");
            }
        }
    }

    // Ranks the cards
    private int getWarValue(Card card) {
        String rank = card.getRank();

        if (rank.equals("Ace")) {
            return 14; // Ace is the highest card in War
        } else if (rank.equals("King")) {
            return 13;
        } else if (rank.equals("Queen")) {
            return 12;
        } else if (rank.equals("Jack")) {
            return 11;
        } else {
            return Integer.parseInt(rank);
        }
    }
}
