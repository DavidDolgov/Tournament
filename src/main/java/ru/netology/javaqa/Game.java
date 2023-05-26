package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register1(String name, Player player) {
        players.put(name, player);
    }

    //  public HashMap<String, Player> findAll1() {
    //      return players1;
    //  }

    public int searchStrengthByName1(String name) {
        if (players.containsKey(name)) {
            Player p = players.get(name);
            return p.getStrength();
        } else {
            return -1;
        }
    }

    public int round1(String playerName1, String playerName2) {
        int strength1 = searchStrengthByName1(playerName1);
        int strength2 = searchStrengthByName1(playerName2);

        if (strength1 == -1) {
            throw new NotRegisteredException(playerName1 + " player name not registered.");
        }
        if (strength2 == -1) {
            throw new NotRegisteredException(playerName2 + " player name not registered.");
        }

        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 < strength2) {
            return 2;
        } else {
            return 0;
        }
    }
}
