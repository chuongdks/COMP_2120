import java.util.Scanner;

public class VarRepeat {
    public static void main(String[] args) {
        /* Type your code here. */
        Scanner scnr = new Scanner(System.in); 
        int userNum, divNum, answer;

        userNum = scnr.nextInt(); 
        divNum = scnr.nextInt();

        System.out.println ((userNum = userNum / divNum) + " " + (userNum = userNum / divNum) + " " + (userNum = userNum / divNum));
   }
}
