
    import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("===== WELCOME TO NUMBER GAME =====");

        do {
            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == randomNumber) {
                    System.out.println(" Congratulations! You guessed the correct number.");
                    totalScore += (maxAttempts - attempt + 1) * 10;
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println(" Too Low!");
                } else {
                    System.out.println(" Too High!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n You lost! The correct number was: " + randomNumber);
            }

            System.out.println("Current Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}

