
package local.collections.exercises.Ex05_Cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Construya mediante una List<String> una lista que represente una baraja (deck) americana,
// con 4 palos (suits):
// - corazones (hearts)
// - picas (spades)
// - diamantes (diamonds)
// - tréboles (clubs)
// 13 cartas cada uno (as (ace), 2, 3,…10, paje (J), reina (Q), rey (K)). 
// Construya el array con dos bucles anidados. 
// Barajela con el método shuffle de Collections. 

// Construya una función repartir que dada una baraja devuelva una mano de “n” cartas, 
// empezando por el final del array (¡la baraja está boca abajo!), 
// use sublistas (subList) y 
// que suprime las cartas de la baraja (método clear), 
// para evitar poder dar dos veces la misma carta. 

// Emplee esta función para repartir “n” cartas a “m” jugadores, 
// recibiendo tanto n como m a través de los argumentos del programa. 
// Previamente debe barajar las cartas,
// para asegurarse que nadie sabe que cartas se repartirán a cada uno.

public class CardsApp {

    List<String> deck = new LinkedList<>();
    int numPlayers;
    int nunHandCards;
    List<List<String>> playerHands = new LinkedList<>();


    public CardsApp(int numPlayers, int nunHandCards) {
        this.numPlayers = numPlayers;
        this.nunHandCards = nunHandCards;
        populateDeck();
        Collections.shuffle(deck);
        dealCards();
    }

    
    private void populateDeck() {
        for (Suits suit : Suits.values()) {
           for (int i = 2; i <= 10 ; i++) {
                deck.add(i + " de " + suit.icon);
           }
           for (FaceCards card : FaceCards.values()) { 
               deck.add(card.icon +  " de " + suit.icon);
           }
        }
    }

    private List<String> makeHand(int num) {
        List<String> hand = new LinkedList<>();
        for (int index = 0; index < num ; index++) {
            hand.add(deck.removeLast());
        }
        return hand;
    }

    private void dealCards() {
        for (int i = 0; i < numPlayers; i++) {
            List<String> hand =  makeHand(nunHandCards);
            playerHands.add(hand);
        }

    }

    public void showHands() {

        // for (List<String> hand : playerHands) {
        //     System.err.println(hand); 
        // }
        // playerHands.forEach(hand -> System.out.println(hand));
        playerHands.forEach(System.out::println);


    } 
 
    public static void main(String[] args) {
       CardsApp cards = new CardsApp(4,5);
       cards.showHands();
    }

}