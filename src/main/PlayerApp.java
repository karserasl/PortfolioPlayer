package main;

import lib.Player;

import java.util.ArrayList;

/**
 * Program to execute a specific job and test some Player Class methods.
 *
 * @author P2424629
 */
public class PlayerApp {

    /**
     * Program to replace the first Player full name, in the ArrayList of Players, with the given full name, and return
     * a String with all the Player's names in format "firstname, LASTNAME", if they contained the letter "a" in their
     * full name.
     *
     * @param players  An ArrayList of Players objects.
     * @param fullName The full name, as String, used to replace the index's 0 full name in the ArrayList.
     * @return The new formatted String containing only the Player's names which have the letter "a" in their full name,
     * in the format "firstname, LASTNAME", followed by a new line.
     */
    public static String execute(ArrayList<Player> players, String fullName) {

        players.get(0).setFullPlayerName(fullName);
        StringBuilder res = new StringBuilder();
        players.stream()
                .filter(p -> p.getName().getFullName().contains("a"))
                .forEach(p -> {
                    res.append(p.getName().getFirstName().toLowerCase());
                    res.append(", ");
                    res.append(p.getName().getFamilyName().toUpperCase());
                    res.append("\n");
                });
        return res.toString();
    }

}