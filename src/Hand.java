import java.util.ArrayList;

public class Hand {

    // Stores all cards in the hand
    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    // Adds a card to the hand
    public void addCard(Card card){
        cards.add(card);
    }

    // Removes a card at the given index
    public Card removeCard(int indexOfCard){
        return cards.remove(indexOfCard);
    }

    // Returns a card at the given index
    public Card getCard(int index){
        return cards.get(index);
    }

    // Returns the number of cards in the hand
    public int size(){
        return cards.size();
    }

    // Removes all cards from the hand
    public void clearCards(){
        cards.clear();
    }

    // Returns a copy of the cards
    public ArrayList<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public String toString(){
        return cards.toString();
    }
}
