/*
2.20 LAB: Driving costs
Driving is expensive. Write a program with a car's gas mileage (miles/gallon) and the cost of gas (dollars/gallon) as floating-point input, and output the gas cost for 20 miles, 75 miles, and 500 miles.

Output each floating-point value with two digits after the decimal point, which can be achieved as follows:
System.out.printf("%.2f", yourValue);

The output ends with a newline.

Ex: If the input is:

25.0 3.1599

where the gas mileage is 25.0 miles/gallon and the cost of gas is $3.1599/gallon, the output is:

2.53 9.48 63.20

Note: Real per-mile cost would also include maintenance and depreciation.

 */
import java.util.Scanner;

public class Drive_Cost {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); 
        double carMileage;  // (miles/gallon)
        double gasCost;  // (dollars/gallon)

        carMileage = scnr.nextDouble(); 
        gasCost = scnr.nextDouble(); 

        /* Type your code here. */
        System.out.printf ("%.2f %.2f %.2f\n", ((20/carMileage) * gasCost), ((75/carMileage) * gasCost), ((500/carMileage) * gasCost));
   }
}
