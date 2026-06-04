import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(int indexOfCard){
        return cards.remove(indexOfCard);
    }

    public Card getCard(int index){
        return cards.get(index);
    }

    public int size(){
        return cards.size();
    }

    public void clearCards(){
        cards.clear();
    }

    // Might need for poker later
    public ArrayList<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public String toString(){
        return cards.toString();
    }
}
