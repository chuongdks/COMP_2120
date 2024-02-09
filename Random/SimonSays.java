import java.util.Scanner;

public class SimonSays {
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      String simonPattern;
      String userPattern;
      int userScore;
      int i;

      userScore = 0;

      simonPattern = scnr.next();
      userPattern  = scnr.next();
      /* Your solution goes here  */
      for (i = 0; i < simonPattern.length(); i++) 
      {
         // Compare characters at the current index
         if (simonPattern.charAt(i) == userPattern.charAt(i)) 
         {
            // Increment userScore for each match
            userScore++;
         } 
         else 
         {
            // Exit the loop if a mismatch is found
            break;
         }
      }

      System.out.println("userScore: " + userScore);

      return;
   }
}