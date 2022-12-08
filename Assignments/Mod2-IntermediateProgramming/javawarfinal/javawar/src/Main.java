import java.util.*;

/**
 * @ author: Will Boese, Richy Phongsavath
 * @ version: 1.0
 * this program simulates a game of war and prints results to console
 * main method instantiates the deck and shuffles it then calls runGame
 */
public class Main {

  public static void main(String[] args) {
    Deck myDeck = new Deck();
    //print all cards in deck
    System.out.println("All cards in deck:");
    for (Card card : myDeck.getCards()) {
      System.out.println(card.toString());
    }
    Collections.shuffle(myDeck.getCards());
    System.out.println("All cards in deck shuffled:\n\n");
    for (Card card : myDeck.getCards()) {
      System.out.println(card.toString());
    }
    realRunGame(myDeck);
  }

  /**
   * This method separates the deck into two player decks and runs until a winner is determined
   * @param deck a deck object of the type Deck
   */
  public static void realRunGame(Deck deck) {
    //create player decks
    ArrayList<Card> player1deck = new ArrayList<Card>();
    ArrayList<Card> player2deck = new ArrayList<Card>();
    ArrayList<Card> pot = new ArrayList<Card>();
    //divide cards into two player decks
    for (int i = 0; i < deck.getCards().size(); i++) {
      if (i % 2 == 0) {
        player1deck.add(deck.getCards().get(i));
      }
      if (i % 2 == 1) {
        player2deck.add(deck.getCards().get(i));
      }
    }
    //WHILE LOOP TO RUN GAME STATE
    int roundCounter = 1;
    while (player1deck.size() > 0 && player2deck.size() > 0) {
      //initiate round counter

      //put cards in pot
      pot.add(player1deck.get(0));
      player1deck.remove(0);
      pot.add(player2deck.get(0));
      player2deck.remove(0);
      System.out.println("Round: " + roundCounter);
      System.out.print("PLAYER 1 CARD: ");
      System.out.println(pot.get(0).toString());
      System.out.print("PLAYER 2 CARD: ");
      System.out.println(pot.get(1).toString());
      //determine winner
      if (rankToIntLoop(pot.get(0)) > rankToIntLoop(pot.get(1))) {
        System.out.println("player 1 wins");
        Collections.shuffle(pot);
        for (int i = 0; i < pot.size(); i++) {
          player1deck.add(pot.get(i));
        }
        pot.clear();
        roundCounter++;
      } else if (rankToIntLoop(pot.get(0)) < rankToIntLoop(pot.get(1))) {
        System.out.println("player 2 wins");
        Collections.shuffle(pot);
        for (int i = 0; i < pot.size(); i++) {
          player2deck.add(pot.get(i));
        }
        pot.clear();
        roundCounter++;
      } else {//in the case of a tie or "war"
        int tieBreaker = 8;
        while (tieBreaker < 51) {

          System.out.println("THERE IS A TIE, DECLARE WAR");
          if (player1deck.size() < 4) {
            //game is over
            System.out.println("P1 NOT ENOUGH CARDS TO DECLARE WAR");
            System.out.println("PLAYER 2 wins");
            return;
          } else if (player2deck.size() < 4) {
            //game is over
            System.out.println("P2 NOT ENOUGH CARDS TO DECLARE WAR");
            System.out.println("PLAYER 1 wins");
            return;
          } else {
            //checking how many cards each player has to troubleshoot potential out-of-bounds error
            System.out.println("P1 cards:");
            System.out.println(player1deck.size());
            System.out.println("P2 cards:");
            System.out.println(player2deck.size());

            //add three cards from player 1
            pot.add(player1deck.get(0));
            player1deck.remove(0);
            pot.add(player1deck.get(0));
            player1deck.remove(0);
            pot.add(player1deck.get(0));
            player1deck.remove(0);

            //add three cards from player 2
            pot.add(player2deck.get(0));
            player2deck.remove(0);
            pot.add(player2deck.get(0));
            player2deck.remove(0);
            pot.add(player2deck.get(0));
            player2deck.remove(0);


            //each player adds one more card
            pot.add(player1deck.get(0));
            player1deck.remove(0);
            pot.add(player2deck.get(0));
            player2deck.remove(0);

            //players compare cards again
            System.out.print("PLAYER 1 CARD: ");
            System.out.println(pot.get(0 + tieBreaker).toString());
            System.out.print("PLAYER 2 CARD: ");
            System.out.println(pot.get(1 + tieBreaker).toString());

            if (rankToIntLoop(pot.get(0 + tieBreaker)) > rankToIntLoop(pot.get(1 + tieBreaker))) {
              System.out.println("PLAYER 1 WINS THE WAR");
              Collections.shuffle(pot);
              for (int i = 0; i < pot.size(); i++) {
                player1deck.add(pot.get(i));
              }
              pot.clear();
              roundCounter++;
              break;
            } else if (rankToIntLoop(pot.get(0 + tieBreaker)) < rankToIntLoop(pot.get(1 + tieBreaker))) {
              System.out.println("PLAYER 2 WINS THE WAR");
              Collections.shuffle(pot);
              for (int i = 0; i < pot.size(); i++) {
                player2deck.add(pot.get(i));
              }
              pot.clear();
              roundCounter++;
              break;
            } else {
              System.out.println("THERE IS A TIE, DECLARE ANOTHER WAR");
              tieBreaker = tieBreaker + 8;
            }
          }
        }
      }
    }
    System.out.println("END GAME");
    System.out.println("P1 cards:");
    System.out.println(player1deck.size());
    System.out.println("P2 cards:");
    System.out.println(player2deck.size());
    if (player1deck.size() > player2deck.size()) {
      System.out.println(" PLAYER 1 Wins");
    }
    if (player1deck.size() < player2deck.size()) {
      System.out.println(" PLAYER 2 Wins");
    }

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