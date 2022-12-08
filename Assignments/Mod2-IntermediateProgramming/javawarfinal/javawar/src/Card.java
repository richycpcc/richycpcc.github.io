/**
 * Represents a card in a deck
 */
public class Card {
  private Suits suit;
  private Ranks rank;
  // Creates a card by taking parameters of suit and rank
  public Card(Suits suit, Ranks rank) {
    this.suit = suit;
    this.rank = rank;
  }

  @Override
  public String toString() {
    return this.rank + " of " + this.suit;
  }

  public Ranks getRank() {
    return rank;
  }

  public Suits getSuit() {
    return suit;
  }
  public void setRank(Ranks rank) {
    this.rank = rank;
  }
  public void setSuit(Suits suit) {
    this.suit = suit;
  }

}

