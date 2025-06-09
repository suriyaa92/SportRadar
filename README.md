# 🟩 Wordle Game – Programming Skill Assessment

This is a command-line version of the popular **Wordle** game, implemented in **Java 17** using **Apache Maven**. It follows a **Test-Driven Development (TDD)** approach and simulates the original game's rules and feedback style.

---

## 📋 Game Rules

- Guess a 5-letter word in **5 attempts**.
- After each guess, feedback is shown for each letter:
   - 🟩 **Green** – Letter is correct and in the correct position.
   - 🟨 **Yellow** – Letter is in the word but in the wrong position.
   - ⬜ **Gray** – Letter is not in the word.
- **Duplicate letters** are handled correctly:
   - Example: If the target is `WATER` and the guess is `OTTER`, only the second `T` is yellow.

---

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java 17 or higher
- Apache Maven

Also ensure that the word list file exists at:
src/main/resources/words.txt

---

## 🚀 Running the Game



```bash
 1. Clone or Download the Project
git clone <your-repo-url>
cd SportRadar

 2. Clone or Download the Project
mvn clean compile

 3. Run the application:
mvn exec:java -Dexec.mainClass="com.game.Wordle"

 4. If required, Run Unit test:
   mvn test
