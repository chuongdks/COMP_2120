import java.util.Scanner;

public class MusicalNote {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double f0 = scnr.nextDouble(); 

        /* Type your code here. */
        double r = Math.pow (2, (double) 1/12); //remember to type cast to double
        double f1 = f0 * Math.pow (r, 1);
        double f2 = f0 * Math.pow (r, 2);
        double f3 = f0 * Math.pow (r, 3);
        System.out.printf("%.2f Hz\n", f0);
        System.out.printf("%.2f Hz\n", f1);
        System.out.printf("%.2f Hz\n", f2);
        System.out.printf("%.2f Hz\n", f3);
    }
}
