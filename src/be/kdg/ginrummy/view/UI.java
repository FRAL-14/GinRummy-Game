package be.kdg.ginrummy.view;

import be.kdg.ginrummy.model.Card;
import be.kdg.ginrummy.model.Player;

import java.util.Locale;
import java.util.Scanner;

public class UI {

    private static final Scanner SCANNER = new Scanner(System.in); // Can be final since the scanner doesn't change

    /**
     * Asks for basic input.
     *
     * @return The input in lowercase.
     */
    private static String askUserInput() {
        System.out.print(" > ");
        return SCANNER.nextLine().toLowerCase(Locale.ROOT);
    }

    /**
     * Called by Game.regularGameChecks() when a user should be able to knock.
     * The user is asked if they want to knock.
     *
     * @return Whether the player wants to knock.
     */
    public static boolean askUserIfKnock() {
        System.out.println("Do you want to knock? (y/n)");
        return askUserIfYesOrNo();
    }

    public static boolean askUserIfTakeUpCard() {
        System.out.println("Do you want to take the up card (y)? (n) takes a card from the deck.");
        return askUserIfYesOrNo();
    }

    private static boolean askUserIfYesOrNo() {
        String input;

        do {
            input = askUserInput();

            if (!"y".equals(input) && !"n".equals(input)) {
                System.out.println("Sorry, incorrect input.");
            }
        } while (!"y".equals(input) && !"n".equals(input)); // Checking for correct input, if not, ask again

        return "y".equals(input);
    }

    public static void askUserToDiscardCard(Player player, Card exception) {
        String input;

        do {
            input = askUserInput();

            if (exception != null && exception.toString().equalsIgnoreCase(input)) {
                System.out.println("You can not choose this card. Try again.");
            }
        } while (exception != null && exception.toString().equalsIgnoreCase(input));

        for (Card card : player.getHAND().getPlayerCards()) {
            if (input.equalsIgnoreCase(card.toString())) {
                player.getHAND().removeCard(player.getHAND().getPlayerCards().indexOf(card));
            }
        }
    }

}
