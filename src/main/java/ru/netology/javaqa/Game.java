package ru.netology.javaqa;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public ArrayList<Player> findAll() {
        return players;
    }
    public int searchStrengthByName(String name) {
        for (Player player: players) {
            if(player.getName().equals(name)) {
                return player.getStrength();
            }
        }
        return 0;
    }
    public int round(String playerName1, String playerName2) {
        int strength1 = searchStrengthByName(playerName1);
        int strength2 = searchStrengthByName(playerName2);

        if (searchStrengthByName(playerName1) == 0) {
            throw new NotRegisteredException(playerName1 + " player name not registered.");
        }
        if (searchStrengthByName(playerName2) == 0) {
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
