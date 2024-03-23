import java.util.Scanner;

public class DriveCost {
    /* Define your method here */
    public double DrivingCost (double milesPerGallon, double dollarsPerGallon, double milesDriven)
    {
        double totalCost = (milesDriven / milesPerGallon) * dollarsPerGallon;
        return totalCost;
    }
    public static void main(String[] args) {
        /* Type your code here. */
        DriveCost bmw = new DriveCost();

        Scanner keyboard = new Scanner(System.in);
        double milesPerGallon = keyboard.nextDouble();
        double dollarsPerGallon = keyboard.nextDouble();
        //double milesDriven = keyboard.nextDouble();

        System.out.printf("%.2f", bmw.DrivingCost (milesPerGallon, dollarsPerGallon, 10));
        System.out.printf("%.2f", bmw.DrivingCost (milesPerGallon, dollarsPerGallon, 50));
        System.out.printf("%.2f", bmw.DrivingCost (milesPerGallon, dollarsPerGallon, 100));
    }
}
