import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

/**
A class to to test the Polynomial class.
*/
public class AirportTester
{
    // Display the menu options.
    static void menu() 
    {
        System.out.println("\nEnter your choice:\n"
            + "> (l) add a plane for landing, followed by the flight id\n"
            + "> (t) add a plane for take-off, followed by the flight id\n"
            + "> (n) perform next action.\n"
            + "> (p) print the planes waiting for landing/take-off.\n"
            + "> (g) print the planes already landed/taken off to the screen\n"
            + "> (f) print the planes already landed/taken off to the output file\n"
            + "> (q) quit the simulation.\n");
    }

    public static void main(String[] args)
    {
        Airport boeing = new Airport();
        Scanner scnr = new Scanner(System.in);
        Boolean quit = false; // Exit program flag
        while(!quit)
        {
            menu();
            String input = scnr.nextLine();
            switch(input.charAt(0))
            {
                case 'l':
                    boeing.addLanding(input.substring(1));
                    break;

                case 't':
                    boeing.addTakeOff(input.substring(1));
                    break;

                case 'n':
                    System.out.println(boeing.handleNextAction());
                    break;

                case 'p':
                    System.out.println(boeing.waitingPlanes());
                    break;

                case 'g':
                    System.out.println(boeing.log());
                    break;

                // case 'f':

                case 'q':
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please choose from the menu\n");
            }
        }
    }
}