package NumberGuessing;
// narasimha edited this one 
import java.util.Random;
import java.util.Scanner;
// these are the import modules
public class Main {
    public static void main(String[] args) {
        // using scanner 
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // giving min number
        int lowerBound = 1; // Lower bound for the random number
        int upperBound = 100; // Upper bound for the random number
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int numberOfTries = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have 10 chances to guess the number.");

        while (numberOfTries < 10 && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfTries++;

            int difference = Math.abs(userGuess - numberToGuess);
            String hotness, coldness;

            if (difference <= 5) {
                hotness = "severe";
            } else if (difference <= 10) {
                hotness = "hot";
            } else {
                hotness = "warm";
            }

            if (difference >= 50) {
                coldness = "freezing";
            } else if (difference >= 20) {
                coldness = "cold";
            } else {
                coldness = "cool";
            }

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + numberOfTries + " tries.");
                hasGuessedCorrectly = true;
            } else {
                System.out.println("Your guess is " + hotness + " and " + coldness + ".");
                System.out.println("You have " + (10 - numberOfTries) + " chances remaining.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've run out of chances. The correct number was " + numberToGuess + ". You lose.");
        }

    }
}
