import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        - ask how many digits the should be √
        - generate random number with n digits √
        - do while user number != number
        - ask user to input number
        - loop -- check every digit of user number compared to every digit in actual number
        -

        1234

        5430

         */

        Scanner keyboard = new Scanner(System.in);
        Random num = new Random();


        System.out.println("how many digits do you want the number to be?");

        int digits = keyboard.nextInt();
//        int[] number = new int[digits];

        int[] number = new int[digits];

        boolean win = false;

        // generating random digits for each index value in the array

        for (int i = 0; i < digits; i++) {
            number[i] = num.nextInt(0,9);
        }

        System.out.println("how many guesses do you want to have?");
        int guessesRemaining = keyboard.nextInt();


        do  {
            guessesRemaining --;

            System.out.println();
            System.out.println("what is your guess?");
            int numGuess = keyboard.nextInt();

            // note: make sure to add the try cache expectation or whatver so that if user enters a string instead of number it prints an error or smth.

            int[] guess = new int[digits];

            for (int i = 0; i < digits; i++) {

                String guessString = String.valueOf(numGuess);
                guess[i] = Character.getNumericValue(guessString.charAt(i));
            }

            int counterCorrectDigit = 0;
            int counterCorrectPlace = 0;
            int[] correct = new int[digits];
            //^  0 = wrong, 1 = correct

            for (int i = 0; i < digits; i++) {
                for (int n = 0; n < digits; n++) {

                    if (guess[i] == number[n]) {

                        counterCorrectDigit++;
                        if (correct[n] == 1) {
                            counterCorrectDigit --;
                        }


                        if (i == n) {
                            correct[n] = 1;
                            counterCorrectPlace++;
                            counterCorrectDigit--;

                            for(int m = 0; m < n; m++){
                                if (guess[m] == guess[n]) {
                                    counterCorrectDigit--;
                                }
                            }
                        }

                        break;
                    }

                }

            }

            System.out.println("you have " + counterCorrectDigit + " correct digit(s) in the wrong place. ");
            if (counterCorrectPlace == digits) {
                win = true;
                break;
            }

            System.out.println("you have " + counterCorrectPlace + " digit(s) in the right place");
            System.out.println();
            System.out.println(guessesRemaining + " guesses remaining");

        } while (guessesRemaining > 0);

        System.out.println();

        if (win) {
            System.out.println("YOU  WIN :D");
        }
        else {
            System.out.println("YOU  LOSE D:");
            System.out.println("the number was ");

            for (int i = 0; i < digits; i++) {
                System.out.print(number[i]);
            }
        }
    }
}