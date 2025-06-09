package com.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public  class Wordle {
    private final String secret;
    private static final int MAX_GUESSES = 5;
    private static final int WORD_LENGTH = 5;


    public Wordle(String secret) {
        this.secret = secret;
    }
// This Method is to check correct word and its char position to highlight
    public String[] checkGuess(String guess) {

        String[] result = new String[WORD_LENGTH];
        boolean[] used = new boolean[WORD_LENGTH];

        // Check for  Green highlight
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                result[i] = "green";
                used[i] = true;
            }
        }

        // Check for  Yellow highlight
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (result[i] == null) {
                boolean found = false;
                for (int j = 0; j < WORD_LENGTH; j++) {
                    if (!used[j] && guess.charAt(i) == secret.charAt(j)) {
                        result[i] = "yellow";
                        used[j] = true;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result[i] = "Gray";
                }
            }
        }
        return result;
    }

// This method reads the words from words.txt file and create word list
    public static List<String> loadWords(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase();
                if (word.length() == WORD_LENGTH) {
                    words.add(word);
                }
            }
        }
        return words;
    }

    public static void main(String[] args) throws IOException {

        List<String> words = loadWords("src/main/resources/words.txt");
        Scanner sc = new Scanner(System.in);

        String secret = words.get(new Random().nextInt(1,5));
        Wordle checker = new Wordle(secret);
        printIntroduction();
        for (int i = 0; i < MAX_GUESSES; i++) {
            String guess;
            while (true) {
                System.out.print("Guess (5 alphabetic letters): ");
                guess = sc.nextLine().toLowerCase().trim();

                if (guess.length() != WORD_LENGTH) {
                    System.out.println("Invalid input. Please enter exactly 5 letters.");
                } else if (!guess.matches("[a-zA-Z]+")) {
                    System.out.println("Invalid input. Only alphabetic characters are allowed.");
                } else {
                    break;
                }
            }

            String[] feedback = checker.checkGuess(guess);
            System.out.print("Feedback: ");
            for (int j = 0; j < MAX_GUESSES; j++) {
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

    //This method is to print Introduction about the game to the user
    private static void printIntroduction() {
        System.out.println("🎮 Welcome to Command-Line Wordle!");
        System.out.println("-------------------------------------");
        System.out.println("How to Play:");
        System.out.println(" - You have 5 attempts to guess a secret 5-letter word.");
        System.out.println(" - After each guess, you’ll get color-coded feedback:");
        System.out.println("     \u001B[42m G \u001B[0m = Correct letter in the correct position (Green)");
        System.out.println("     \u001B[43m Y \u001B[0m = Correct letter but wrong position (Yellow)");
        System.out.println("     \u001B[47m W \u001B[0m = Letter not in the word (Gray)");
        System.out.println(" - Repeated letters are treated carefully: no extra highlights.");
        System.out.println(" - Guesses must be 5 letters, alphabets only.\n");
    }
}