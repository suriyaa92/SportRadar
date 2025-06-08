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

    @Test
    public void testLetterInWrongPositionIsYellow() {
        Wordle wordle = new Wordle("apple");
        String[] feedback = wordle.checkGuess("pleap");

        // P is in wrong spot (yellow), L in wrong spot, etc.
        assertEquals("yellow", feedback[0]);
        assertEquals("yellow", feedback[1]);
        assertEquals("yellow", feedback[2]);
        assertEquals("yellow", feedback[3]);
        assertEquals("yellow", feedback[4]);
    }

}
