import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random= new Random();
        int lb=1;
        int ub=100;
        int range=ub-lb+1;
        int max=5;
        boolean play=true;
        while(play)
        {
            int target=lb+random.nextInt(range);
            int attempts=0;
            boolean guess=false;
            System.out.println("Welcome");
            System.out.println("I have selected a number between"+lb+ " and " +ub+".Try to guess it!");
             while(attempts<max && !guess){
                System.out.print("Enter the guess:");
                int userGuess=scanner.nextInt();
                attempts++;
                if(userGuess==target)
                {
                    System.out.println("Congratultions!you guessed the correct number in"+attempts+"attempts.");
                    guess=true;
                }
                else if (userGuess<target)
                {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }
            }

            if (!guess) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + target);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            play = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }
}
                