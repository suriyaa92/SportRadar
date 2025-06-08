package com.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordleTest {

    @Test
    public void testExactMatchGivesAllGreen() {
        Wordle wordle = new Wordle("apple");
        String[] feedback = wordle.checkGuess("apple");

        assertArrayEquals(new String[]{"green", "green", "green", "green", "green"}, feedback);
    }
}
