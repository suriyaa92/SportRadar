package com.game;

import java.util.Scanner;

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
        
        Scanner sc = new Scanner(System.in);
        String secret = "apple";  // hardcoded for now
        Wordle checker = new Wordle(secret);

        System.out.println("Welcome to Wordle!");
        for (int i = 0; i < 5; i++) {
            System.out.print("Guess: ");
            String guess = sc.nextLine().toLowerCase();
            String[] feedback = checker.checkGuess(guess);
            System.out.print("Feedback: ");
            for (int j = 0; j < 5; j++) {
                String color = feedback[j];
                char c = guess.charAt(j);
                switch (color) {
                    case "green":
                        System.out.print("\u001B[42m " + Character.toUpperCase(c) + " \u001B[0m");
                        break;
                    case "yellow":
                        System.out.print("\u001B[43m " + Character.toUpperCase(c) + " \u001B[0m");
                        break;
                    default:
                        System.out.print("\u001B[47m " + Character.toUpperCase(c) + " \u001B[0m");
                        break;
                }
            }
            System.out.println();

            if (guess.equals(secret)) {
                System.out.println("You win!");
                return;
            }
        }
        System.out.println("Out of tries. The word was: " + secret);

          }
}