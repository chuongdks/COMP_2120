import java.util.Scanner;

public class Laps2Miles {
   
    /* Define your method here */ 
    private double laps;

    public Laps2Miles ()
    {
        this.laps = 0.0;
    }
    public double lapsToMiles (double laps)
    {
        return this.laps = laps * 0.25;
    }
    public static void main(String[] args) {
        /* Type your code here. Your code must call the method.  */
        Laps2Miles laps = new Laps2Miles();
        
        Scanner keyboard = new Scanner(System.in);
        double num1 = keyboard.nextDouble();

        System.out.printf("%.2f\n", laps.lapsToMiles (num1));
    }
}
