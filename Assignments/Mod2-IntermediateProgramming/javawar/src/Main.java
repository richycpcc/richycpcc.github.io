import java.util.*;

public class Main {

  public static void main(String[] args) {
    Deck myDeck = new Deck();
    //print all cards in deck
    System.out.println("All cards in deck:");
    for(Card card : myDeck.getCards()) {
      System.out.println(card.toString());
      //System.out.println(card.getSuit());
    }
    realRunGame(myDeck);
  }

  public static void realRunGame(Deck deck) {
    //create player decks
    ArrayList<Card> player1deck = new ArrayList<Card>();
    ArrayList<Card> player2deck = new ArrayList<Card>();
    ArrayList<Card> pot = new ArrayList<Card>();
    //divide cards into two player decks
    for(int i = 0; i < deck.getCards().size(); i++) {
      if(i % 2 == 0) {
        player1deck.add(deck.getCards().get(i));
      }
      if(i % 2 == 1) {
        player2deck.add(deck.getCards().get(i));
      }
    }
    //WHILE LOOP TO RUN GAME STATE
    while (player1deck.size() > 0 && player2deck.size() > 0) {
      //initiate round counter


      //put cards in pot
      pot.add(player1deck.get(0));
      player1deck.remove(0);
      pot.add(player2deck.get(0));
      player2deck.remove(0);
      System.out.println("PLAYER 1 CARD");
      System.out.println(pot.get(0).toString());
      System.out.println("PLAYER 2 CARD");
      System.out.println(pot.get(1).toString());
      System.out.println("DETERMINE WINNER:");
      if(rankToIntLoop(pot.get(0)) > rankToIntLoop(pot.get(1))) {
        System.out.println("player 1 wins");
        for(int i = 0; i < pot.size(); i++) {
          player1deck.add(pot.get(i));
        }
        pot.clear();
      } else if (rankToIntLoop(pot.get(0)) < rankToIntLoop(pot.get(1))){
        System.out.println("player 2 wins");
        for(int i = 0; i < pot.size(); i++) {
          player2deck.add(pot.get(i));
        }
        pot.clear();
      } else {
        System.out.println("THERE IS A TIE");
        return;
      }
    }
    //System.out.println("END GAME");

  }

  public static int rankToIntLoop(Card card) {
    int output = 0;
    int counter = 1;
    for (Ranks rank : Ranks.values()) {
      if (card.getRank() == rank) {
        output = counter;
        break;
      }
      counter++;
    }
    return output;
  }

}