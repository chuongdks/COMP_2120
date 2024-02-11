/*
 * Given a positive integer num, the following rules will always create a sequence that ends with 1, called the hailstone sequence:

    If num is even, divide it by 2
    If num is odd, multiply it by 3 and add 1 (i.e. 3*num +1)
    Continue until num is 1

Write a method, hailstone(), that takes in a positive integer as a parameter and prints the hailstone sequence starting with that integer. Format the output so that ten integers, each separated by a tab character (\t), are printed per line. Assume the input to the program is always positive.

The output format can be achieved as follows:
System.out.print(num + "\t");

Ex: If the program input is:

25

the output of method hailstone() is:

25   76   38   19   58   29   88   44   22   11 
34   17   52   26   13   40   20   10   5    16 
8    4    2    1

Note: Your program must define the method:
public void hailstone(int num)

 */

import java.util.Scanner;

public class Hailstone {

   /* Type your code here. */   
   public void hailstone(int num)
   {
      int counter = 0;
      while (num != 1)
      {
         System.out.print(num + "\t");
         if (num % 2 == 0)
         {
            num = num / 2;
         }
         else
         {
            num = 3*num + 1;
         }
         counter++;
         if (counter == 10)
         {
            System.out.print("\n");
            counter = 0;
         }
      }
      
      System.out.print(num + "\n");
   }
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      Hailstone labObject = new Hailstone();
      int num;
      
      num = scnr.nextInt();
      labObject.hailstone(num); // Call hailstone() to print out the hailstone sequence.
   }
}
