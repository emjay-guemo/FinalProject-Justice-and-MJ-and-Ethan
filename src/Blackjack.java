public class Blackjack extends CasinoGame {

    @Override
    public boolean play() {

        playerTurn();
        dealerTurn();
        return determineWin();
    }

    private Deck deck;
    private Player player;
    private Player dealer;

    public Blackjack(Player player){
        deck = new Deck();
        deck.shuffle();

        this.player = player;
        this.dealer = new Player("Dealer");

        player.getHand().addCard(deck.dealCard());
        player.getHand().addCard(deck.dealCard());

        dealer.getHand().addCard(deck.dealCard());
        dealer.getHand().addCard(deck.dealCard());
    }

    public void playerTurn(){
        System.out.println("Your Hand: " + player.getHand().getValue());

        while (player.getHand().getValue() < 21){
            String playerChoice = Input.getUserString("""
                    H for Hit
                    S for Stand
                    D for Double
                    """);

            if (playerChoice.equalsIgnoreCase("H")){
                System.out.println("Hit");
                player.getHand().addCard(deck.dealCard());
                System.out.println(player.getHand() + "Value " + player.getHand().getValue());
            }
            if (playerChoice.equalsIgnoreCase("S")){
                break;
            }
            if (playerChoice.equalsIgnoreCase("D")){
                System.out.println("Double");
                player.getHand().addCard(deck.dealCard());
                System.out.println(player.getHand() + "Value " + player.getHand().getValue());
                break;
            }
        }
    }

    public boolean determineWin(){
        int playerScore = player.getHand().getValue();
        int dealerScore = dealer.getHand().getValue();

        if (playerScore > 21){
            System.out.println("Dealer Wins!");
            return false;
        }
        else if (dealerScore > 21) {
            System.out.println("Player Wins!");
            return true;
        }
        else if (playerScore > dealerScore) {
            System.out.println("Player Wins!");
            return true;
        }
        else if (dealerScore > playerScore) {
            System.out.println("Dealer Wins!");
            return false;
        }
        else {
            System.out.println("Push/Tie");
            return false;
        }
    }

    public void dealerTurn(){
        while (dealer.getHand().getValue() < 17){
            dealer.getHand().addCard(deck.dealCard());
        }

        System.out.println("Dealer's Hand" + dealer.getHand());
        System.out.println("Dealer's Value" + dealer.getHand().getValue());

    }

    /*
    Game overview: Dealer deals everyone 2 cards, he has one card shown, the other one hidden
    with the back of the card being shown to everyone

    Rules: Dealer hits on all 16's and stand on all 17's
    (meaning if their hand is 16, they have to pull another card and if their hand is 17
    or bigger, they have to stand, meaning no more pulling cards.

    Win Conditions:
    Player:
    The dealer busts (Hand goes over 21)
    Player's hand is closer to 21 than the dealer's
    Player gets blackjack (21)

    Dealer:
    Player Busts (Hand goes over 210
    Dealer's hand is closer to 21 than the player's
    The dealer gets blackjack (21)

    Tie:
    Both the player and the dealer have the same score.
     */


}
