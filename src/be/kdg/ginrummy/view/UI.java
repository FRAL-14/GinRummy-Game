package be.kdg.ginrummy.view;

import java.util.Locale;
import java.util.Scanner;

public class UI {

    private static final Scanner SCANNER = new Scanner(System.in); // Can be final since the scanner doesn't change

    /**
     * Asks for basic input.
     * @return The input in lowercase.
     */
    static String askUserInput() {
        System.out.print(" > ");
        return SCANNER.nextLine().toLowerCase(Locale.ROOT);
    }

    /**
     * Called by Game.regularGameChecks() when a user should be able to knock.
     * The user is asked if they want to knock.
     * @return Whether the player wants to knock.
     */
    static boolean askUserIfKnock() {
        System.out.println("Do you want to knock? (y/n)");
        String input;
        do {
            input = askUserInput();

            if (!"y".equals(input) && !"n".equals(input)) {
                System.out.println("Sorry, incorrect input.");
            }
        } while (!"y".equals(input) && !"n".equals(input)); // Checking for correct input, if not, ask again

        return "y".equals(input);
    }

}
