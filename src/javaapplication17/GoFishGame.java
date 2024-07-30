/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;
import java.util.Scanner;
/**
 *
 * @author Avnoor Kaur
 */
public class GoFishGame extends Game{
    private GoFishGroupOfCards deck;
    private GoFishPlayer user;
    private GoFishPlayer computer;

    public GoFishGame() {
        super("Go Fish");
        deck = new GoFishGroupOfCards(52);
        deck.initializeDeck();
        user = new GoFishPlayer("User");
        computer = new GoFishPlayer("Computer");
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        // Initial draw
        for (int i = 0; i < 7; i++) {
            user.addCard(deck.drawCard());
            computer.addCard(deck.drawCard());
        }

        while (true) {
            user.displayHand();
            System.out.println("Ask for a rank:");
            String rank = scanner.nextLine();

            Card card = computer.getCard(rank);
            if (card != null) {
                System.out.println("Computer has " + card + ". You get the card.");
                user.addCard(card);
                computer.removeCard(card);
            } else {
                System.out.println("Go Fish!");
                if (!deck.isEmpty()) {
                    user.addCard(deck.drawCard());
                }
            }

            // Computer's turn (simplified)
            if (!computer.getHand().isEmpty()) {
                Card computerCard = computer.getHand().get(0);
                rank = ((GoFishCard) computerCard).getRank();
                System.out.println("Computer asks for: " + rank);

                card = user.getCard(rank);
                if (card != null) {
                    System.out.println("You have " + card + ". Computer gets the card.");
                    computer.addCard(card);
                    user.removeCard(card);
                } else {
                    System.out.println("Computer goes fishing!");
                    if (!deck.isEmpty()) {
                        computer.addCard(deck.drawCard());
                    }
                }
            }

            if (deck.isEmpty() && user.getHand().isEmpty() && computer.getHand().isEmpty()) {
                break;
            }
        }

        declareWinner();
        scanner.close();
    }

    @Override
    public void declareWinner() {
        // Simple winner declaration based on the number of cards
        if (user.getHand().size() > computer.getHand().size()) {
            System.out.println("User wins!");
        } else if (user.getHand().size() < computer.getHand().size()) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}

