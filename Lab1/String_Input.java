import java.util.Scanner;

public class String_Input {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userName;

        userName = scnr.next();

        /* Type your code here. */
        System.out.printf ("Hey %s!\n", userName);
        System.out.printf ("Welcome to zyBooks!\n");
   }
}
