/*
 * Given a GVDie object and an integer that represents the number of rolls as parameters complete method rollSpecificTimes() in RollingDice class. The method rollSpecificTimes() should calculate and return the running sum of rolling the die the given number of times. Review the definition of "GVDie.java" by clicking on the orange arrow.

Note: For testing purposes, a GVDie object is created in the main() method using a pseudo-random number generator with a fixed seed value. The program uses a seed value of 15 during development, but when submitted, a different seed value will be used for each test case. Refer to the textbook section on Random numbers to learn more about pseudo-random numbers.

Ex: If the GVDie objects are created with a seed value of 15 and the input of the program is:

100

the output is:

100 rolls return a total of 334.

 */

import java.util.Scanner;

public class RollingDice {
   public int rollSpecificTimes(GVDie die, int rolls){
      /* Type your code here. */    
      int sum = 0;
      for (int i = 0; i < rolls; i++)
      {
         die.roll();
         sum += die.getValue();
      }
      return sum;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      RollingDice game = new RollingDice();
      GVDie die = new GVDie();   // Create a GVDie object
      die.setSeed(15);   // Set the GVDie object with seed value 15
      int rolls;
      int total;
      int repeats;
      
      rolls = scnr.nextInt();
      repeats = 100;
      total = game.rollSpecificTimes(die, rolls);   // Call rollSpecificTimes() and return the total.
      System.out.println(rolls + " rolls return a total of " + total + ".");
   }
}
