package ru.netology.javaqa;

public class Game {
    private Player[] players = new Player[0];

    public void register(Player player) {
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
    }

    public Player[] findAll() {
        return players;
    }

    public int searchStrengthByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
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
        }else {
            return 0;
        }
    }
}
