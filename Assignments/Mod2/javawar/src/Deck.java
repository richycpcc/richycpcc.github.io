import java.util.ArrayList;

public class Deck {
  private ArrayList<Card> cards;
  public Deck(){
    this.cards = new ArrayList<Card>();
    for (Suits s : Suits.values()) {
      for (Ranks r : Ranks.values()) {
        Card c = new Card(s,r);
        cards.add(c);
      }
    }
  }
  public void setCards(ArrayList<Card> cards) {
    this.cards = cards;
  }

  public ArrayList<Card> getCards() {
    return cards;
  }
}
