import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    /*
     * Deck Class
     *
     * Responsibilities:
     * - Store all Card objects in an ArrayList<Card>
     * - Create a standard 52-card deck using all suits and ranks
     * - Shuffle the deck before gameplay
     * - Deal cards to players
     * - Track how many cards remain in the deck
     * - Rebuild and reset the deck when starting a new game
     */

    public Deck()
    {
        cards = new ArrayList<Card>();
        buildDeck();
        shuffle();
    }

    // Creates all 52 cards
    public void buildDeck()
    {
        cards.clear();

        String[] suits =
                {
                        "Hearts",
                        "Diamonds",
                        "Clubs",
                        "Spades"
                };

        String[] ranks =
                {
                        "Ace",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7",
                        "8",
                        "9",
                        "10",
                        "Jack",
                        "Queen",
                        "King"
                };

        for (String suit : suits)
        {
            for (String rank : ranks)
            {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Randomizes card order
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    // Returns and removes the top card
    public Card dealCard()
    {
        if (cards.isEmpty())
        {
            return null;
        }

        return cards.remove(0);
    }

    // Returns number of cards left
    public int cardsRemaining()
    {
        return cards.size();
    }

    // Checks if deck is empty
    public boolean isEmpty()
    {
        return cards.isEmpty();
    }

    // Rebuilds and shuffles the deck
    public void reset()
    {
        cards.clear();
        buildDeck();
        shuffle();
    }

}
