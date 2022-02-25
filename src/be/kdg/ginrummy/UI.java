package be.kdg.ginrummy;

import java.util.Locale;
import java.util.Scanner;

public class UI {

    private static Scanner scanner = new Scanner(System.in);

    public static String askUserInput() {
        System.out.print(" > ");
        return scanner.nextLine().toLowerCase(Locale.ROOT);
    }

    public static boolean askUserIfKnock() {
        System.out.println("Do you want to knock? (y/n)");
        String input;
        do {
            input = askUserInput();

            if (!"y".equals(input) && !"n".equals(input)) {
                System.out.println("Sorry, incorrect input.");
            }
        } while (!"y".equals(input) && !"n".equals(input));

        return "y".equals(input); 
    }

}
