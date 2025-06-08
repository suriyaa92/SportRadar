package com.game;

public  class Wordle {
    private final String secret;

    public Wordle(String secret) {
        this.secret = secret;
    }

    public String[] checkGuess(String guess) {

        String[] result = new String[5];
        boolean[] used = new boolean[5];

        // Check for  Green highlight
        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                result[i] = "green";
                used[i] = true;
            }
        }

        // Check for  Yellow & white highlight
        for (int i = 0; i < 5; i++) {
            if (result[i] == null) {
                boolean found = false;
                for (int j = 0; j < 5; j++) {
                    if (!used[j] && guess.charAt(i) == secret.charAt(j)) {
                        result[i] = "yellow";
                        used[j] = true;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result[i] = "white";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}