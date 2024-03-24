import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        long phoneNumber;
        // Add more variables as needed

        phoneNumber = scnr.nextLong();

        /* Type your code here. */
        //Phone number: 800 555 1212. Output: (800) 555-1212
        long rightNumber = phoneNumber % 10000; // Last 4 digits of phoneNumber, 

        long leftNumber = phoneNumber / 10000000; // First 3 digits of phoneNumber

        long middleNumber = (phoneNumber/10000) % 1000; // (phone / 1 0000) = 800 555; phone % 1000 = 555

        System.out.println("(" + leftNumber + ")" + " " + middleNumber + "-" + rightNumber );
    }
}
