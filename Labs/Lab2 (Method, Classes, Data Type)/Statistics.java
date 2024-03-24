import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int num1 = scnr.nextInt();
        int num2 = scnr.nextInt();
        int num3 = scnr.nextInt();
        int num4 = scnr.nextInt();

        /* Type your code here. */
        int productInt = num1 * num2 * num3 * num4;
        int avgInt = (num1 + num2 + num3 + num4) / 4;

        double product = (double)num1 * (double)num2 * (double)num3 * (double)num4;
        double avg = (double)(num1 + num2 + num3 + num4) / 4;
        
        System.out.printf("%d %d\n", productInt, avgInt);
        System.out.printf("%.3f %.3f\n", product, avg);
    }
}
