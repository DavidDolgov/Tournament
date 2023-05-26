package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {
    Player player1 = new Player(1, "Kolya", 10);
    Player player2 = new Player(2, "Dima", 20);
    Player player3 = new Player(3, "Fima", 30);
    Player player4 = new Player(4, "Olya", 40);
    Player player5 = new Player(5, "Danya", 50);
    Player player6 = new Player(6, "Dasha", 60);
    Player player7 = new Player(7, "Masha", 70);
    Player player8 = new Player(8, "Sasha", 80);
    Player player9 = new Player(9, "Kostya", 90);
    Player player10 = new Player(10, "Kirill", 10);

    Game player = new Game();

    @BeforeEach
    public void setup() {
        player.register(player1);
        player.register(player2);
        player.register(player3);
        player.register(player4);
        player.register(player5);
        player.register(player6);
        player.register(player7);
        player.register(player8);
        player.register(player9);
        player.register(player10);
    }

    @Test
    public void shouldRegisterEveryone() {

        Player[] expected = {player1, player2, player3, player4, player5, player6, player7, player8, player9, player10};
        Player[] actual = player.findAll().toArray(new Player[0]);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayers1() {

        int expected = 2;
        int actual = player.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayers2() {

        int expected = 2;
        int actual = player.round(player2.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayers3() {

        int expected = 1;
        int actual = player.round(player6.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayers4() {

        int expected = 1;
        int actual = player.round(player9.getName(), player8.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayers5() {

        int expected = 0;
        int actual = player.round(player10.getName(), player1.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayers6() {

        int expected = 0;
        int actual = player.round(player1.getName(), player10.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoPlayers7() {

        int expected = 0;
        int actual = player.round(player1.getName(), player1.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePlayerWithUnregistered1() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            player.round(player1.getName(), "David");
        });
    }

    @Test
    public void shouldComparePlayerWithUnregistered2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            player.round("David", player1.getName());
        });
    }

    @Test
    public void shouldCompareTwoUnregisteredPlayers() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            player.round("David", "Diana");
        });
    }

}
