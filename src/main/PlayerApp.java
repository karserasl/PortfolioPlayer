package main;

import lib.Player;

import java.util.ArrayList;

public class PlayerApp {

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