
import javax.swing.*;

public class GuessingGame {

    public static void main(String[] args) {
        int computerNumber = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess is " + computerNumber);
        Process(userAnswer,computerNumber);
    }
    public static void Process(int userAnswer, int computerNumber){
        int count = 1;
        while (userAnswer != computerNumber){
            String response = JOptionPane.showInputDialog(null,"Enter a guess number between 1 and 100", "Guessing Game", 3);

            if(response==null){
                JOptionPane.showMessageDialog(null,"Oh! You don't want to play?\n Thankyou for playing, you made "+count+" attempts");
                System.exit(0);
            }
            try{
                userAnswer = Integer.parseInt(response);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Enter only numbers");
                count++;
            }
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count));
            count++;
        }
    }
    public static String determineGuess(int userAnswer, int computerNumber, int count){

        if (userAnswer <=0 || userAnswer >100) {
            return"Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return"Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > computerNumber) {
            if(userAnswer-10<=computerNumber){
                return "You're really close, a little lower\n Try Number: "+count;
            }
            else{
                return"Your guess is to Large, try again later.\nTry Number: " + count;
            }
        }
        else if (userAnswer < computerNumber) {
            if(userAnswer+10>=computerNumber){
                return "You're really close, try a little higher.\nTry Number: " + count;
            }
            else{
                return"Your guess is too small, try again later.\nTry Number: " + count;
            }
        }
        else {
            return"Your guess is incorrect\nTry Number: " + count;
        }

    }

}