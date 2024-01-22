import java.util.Scanner;

//User input 2 times
public class Input_Two {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int currentPrice; 
        int lastMonthsPrice; 

        currentPrice = scnr.nextInt(); 
        lastMonthsPrice = scnr.nextInt();
        System.out.println ("This house is $" +  currentPrice + ". The change is $" + (currentPrice - lastMonthsPrice) + " since last month.");
        System.out.println ("The estimated monthly mortgage is $" + ((currentPrice * 0.051) / 12) + ".");
        /* Type your code here. */
   }
}
