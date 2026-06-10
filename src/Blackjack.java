public class Blackjack extends CasinoGame {

    private Deck deck;
    private Player player;
    private Player dealer;
    private int targetScore;

    Hand hand = new Hand();

    public Blackjack(){
        deck = new Deck();
        deck.shuffle();

        player = new Player("Player");
        dealer = new Player("Dealer");
    }

    boolean playerTurn = true;
    while (playerTurn){
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
