import java.util.Scanner;
import java.util.Random;

public class LabProgram {
   
    // TODO: Define your method here
    public static String coinFlip (Random rand) 
    {
        int result = rand.nextInt(2); // Generates random integer either 0 or 1
        if (result == 1) 
        {
            return "Heads";
        }
        else 
        {
            return "Tails";
        }
    }
   
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random(2); // Unique seed

        // TODO: Complete main here
        int numFlips = scnr.nextInt();

        // Perform coin flips
        for (int i = 0; i < numFlips; i++) 
        {
            String result = coinFlip (rand);
            System.out.println (result);
        }
    }
}
