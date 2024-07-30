/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Avnoor Kaur
 */
public class GoFishPlayer extends Player{
    private List<Card> hand;

    public GoFishPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public boolean removeCard(Card card) {
        return hand.remove(card);
    }

    public Card getCard(String rank) {
        for (Card card : hand) {
            if (((GoFishCard) card).getRank().equals(rank)) {
                return card;
            }
        }
        return null;
    }

    public List<Card> getHand() {
        return hand;
    }

    @Override
    public void play() {
        // Logic for player's turn will be handled in the game class
    }

    public void displayHand() {
        System.out.println(super.getName() + "'s hand: " + hand);
    }
}

