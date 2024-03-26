import java.util.Scanner;
import java.util.NoSuchElementException;

public class NumberOfInputs {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      int val1;
      int val2;
      int val3;
      int max;
      
      val1 = 0;
      val2 = 0;
      val3 = 0;
      
      /* Type your code here. */
      int counter = 0;
      try 
      {
         val1 = scnr.nextInt();
         counter++;
         val2 = scnr.nextInt();
         counter++;
         val3 = scnr.nextInt();
         counter++;
      
         max = Math.max(val1, Math.max(val2, val3)); // Java already imported Finding Max value
         System.out.println(max);
      } 
      
      catch (NoSuchElementException e) 
      {
         if (counter == 0) 
         {
             System.out.println("0 input(s) read:\nNo max");
         } 
         else 
         {
             System.out.println(counter + " input(s) read:");
             System.out.println("Max is " + Math.max(val1, Math.max(val2, val3)));
         }
      }      
   }
}
