/************************* Class Name: Quadratic.java ************************/
/**
* A class to represent a quadratic polynomial.
* Write the header of the class Quadratic which is a subclass of the Polynomial class.
*/
public class Quadratic extends Polynomial {
    /** Define two instance variables:
    * 1- root1: The first root of the quadratic polynomial (double).
    * 2- root2: The second root of the quadratic polynomial (double).
    */    
    // Two extra Instance variables, root1 and root2
    private double root1;
    private double root2;

    /** Constructor
    * Constructs a quadratic polynomial.
    * It must first call the default constructor of its superclass.
    * Then, using three integer parameters as the quadratic polynomial, and the add method of
    * its superclass creates the quadratic.
    * It also should calculate the quadratic roots by calling the roots method, developed later
    * in this class.
    * @param a an integer as the coefficient of the term with power 2
    * @param b an integer as the coefficient of the term with power 1
    * @param c an integer as the coefficient of the term with power 0 (constant value of the
    * quadratic polynomial)
    */
    // Constructor
    public Quadratic(int a, int b, int c) {
        // Call superclass default constructor
        super(); 

        // Add the quadratic polynomial terms using the Polynomial add() method and Polynomial second constructor
        this.add(new Polynomial(2, a));
        this.add(new Polynomial(1, b));
        this.add(new Polynomial(0, c));

        // Calculate the roots, develope later in the class?
        this.roots();
    }

    /** Method Name: getRoot1
    * This method gets the first root of the quadratic polynomial (implicit parameter).
    * @return the first root of the quadratic polynomial
    */
    // Getter method for root1
    public double getRoot1() 
    {
        return this.root1;
    }

    /** Method Name: getRoot2
    * This method gets the second root of the quadratic polynomial (implicit parameter).
    * @return the second root of the quadratic polynomial
    */
    // Getter method for root2
    public double getRoot2() 
    {
        return this.root2;
    }

    /** Method Name: roots
    * This method must calculate the roots of the quadratic polynomial (implicit parameter).
    * @return true if the quadratic polynomial has root(s), false otherwise.
    */
    // Method to calculate roots
    public boolean roots() 
    {
        // Use the coefficient() method from Polynimial class
        int a = this.coefficient(2);
        int b = this.coefficient(1);
        int c = this.coefficient(0);
        double delta = b * b - 4 * a * c; // delta = b^2 - 4ac.  

        // If delta > 0: two solutions, delta = 0: one solution. root = (-b +- sqrt(delta)) / 2a 
        if (delta >= 0) 
        {
            this.root1 = (-b + Math.sqrt(delta)) / (2 * a);
            this.root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return true; 
        }
        // Else if delta < 0: zero solution
        else if (delta < 0)
        {
            return false; 
        }
        return false; // need this cuz Java said missing return statement
    }
}
