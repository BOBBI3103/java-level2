import java.util.Random;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		int minRange = 1;
		int maxRange = 100;
		int maxAttempts = 5;
		int score = 0;
		int rounds = 0;
		JFrame f = new JFrame();

		boolean playAgain = true;
		while (playAgain) {
			int targetNumber = generateRandomNumber(minRange, maxRange);
			int attempts = 0;
			boolean guessedCorrectly = false;

			while (attempts < maxAttempts && !guessedCorrectly) {
				int userGuess = getUserGuess(minRange, maxRange);

				if (userGuess == targetNumber) {
					JOptionPane.showMessageDialog(f,"Congratulations! You guessed the correct number.");
					score += maxAttempts - attempts;
					guessedCorrectly = true;
				} else if (userGuess < targetNumber) {
					JOptionPane.showMessageDialog(f,"Too low! Try again.");
				} else {
					JOptionPane.showMessageDialog(f,"Too high! Try again.");
				}

				attempts++;
			}

			if (!guessedCorrectly) {
				JOptionPane.showMessageDialog(f,"Sorry, you did not guess the correct number. The number was: " + targetNumber);
			}

			rounds++;
			System.out.println("Current score: " + score);
			JOptionPane.showMessageDialog(f,"Current score: " + score);
			System.out.println("Number of rounds played: " + rounds);
			JOptionPane.showMessageDialog(f,"Number of rounds played: " + rounds);

			int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
			playAgain = (choice == JOptionPane.YES_OPTION);
		}

		System.out.println("Thank you for playing!");
		JOptionPane.showMessageDialog(f,"Thank you for playing!");
	}

	private static int generateRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	private static int getUserGuess(int min, int max) {
		int guess = 0;
		boolean validInput = false;
		String input;

		while (!validInput) {
			input = JOptionPane.showInputDialog("Guess a number between " + min + " and " + max + ":");
			try {
				guess = Integer.parseInt(input);
				if (guess < min || guess > max) {
					System.out.println("Invalid input. Please enter a number within the range.");
				} else {
					validInput = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		}

		return guess;
	}
}
