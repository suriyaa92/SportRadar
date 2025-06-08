package com.game;

public  class Wordle {
    private final String secret;

    public Wordle(String secret) {
        this.secret = secret;
    }

    public String[] checkGuess(String guess) {
        String[] result = new String[5];
        for (int i = 0; i < 5; i++) {
            result[i] = guess.charAt(i) == secret.charAt(i) ? "green" : "white";
        }
        return result;
    }

    public static void main(String[] args) {

    }
}