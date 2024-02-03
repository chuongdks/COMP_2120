import java.util.Scanner;

/* A game inspired by "Mad Libs" where user enters nouns,
   verbs, etc., and then a story using those words is output.
*/

public class StoryGame {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String wordRelative;
      String wordFood;
      String wordAdjective;
      String wordTimePeriod;

      // Get user's words
      System.out.println("Provide input without spaces.");

      System.out.println("Enter a kind of relative: ");
      wordRelative = scnr.next();

      System.out.println("Enter a kind of food: ");
      wordFood = scnr.next();

      System.out.println("Enter an adjective: ");
      wordAdjective = scnr.next();

      System.out.println("Enter a time period: ");
      wordTimePeriod = scnr.next();

      // Tell the story
      System.out.println();
      System.out.print  ("My " + wordRelative);
      System.out.println(" says eating " + wordFood);
      System.out.println("will make me more " + wordAdjective + ",");
      System.out.println("so now I eat it every " + wordTimePeriod + ".");
   }
}