/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author Avnoor Kaur
 */
public class GoFishGroupOfCards extends GroupOfCards{
    private List<Card> cards;

    public GoFishGroupOfCards(int size) {
        super(size);
        cards = new ArrayList<>();
    }

    public void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new GoFishCard(rank, suit));
            }
        }

        shuffle();
    }
    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public ArrayList<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}


   
