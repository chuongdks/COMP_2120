import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

/** 
* A class to represent a polynomial.
* Write the header of the class Polynomial that must implement the Comparable interface.
*/
public class Polynomial implements Comparable<Polynomial> {
    /**
    * Define two instance variables:
    * 1- terms: A Map that keeps the power and coefficient of the terms of a polynomial.
    * Both power and coefficient are integers.
    * 2- degree: An integer that keeps the degree of the polynomial 
    */    
    // Instance variables
    private Map<Integer, Integer> terms;
    private int degree;

    /**     Default Constructor
    * Constructs an empty polynomial.
    * Polynomial should be in reverse order, such that the terms are stored in descending order.
    * The degree of an empty polynomial should be set to -1.
    * The type of the Map for the instance filed terms must be TreeMap, which can keep the order
    * of the polynomial terms.
    */
    // Default Constructor, create empty Polynomial Class
    public Polynomial() {
        this.terms = new TreeMap<>(Collections.reverseOrder()); // Polynomial is in reverse order using the Hint
        this.degree = -1;
    }

    /** Second Overloaded Constructor
    * Constructs a new polynomial with two parameters, power and coefficient, as one term.
    * It must first call the default constructor to create an empty polynomial.
    * Then, it must check the power value, and if it is negative, it must throw an
    * IllegalArgumentException exception with a proper message. Otherwise, it creates one term
    * for the polynomial using the power and coefficient given to the method as two parameters.
    * @param power the term power (int)
    * @param coefficient the term coefficient (int)
    */
    // Second Overloaded Constructor
    public Polynomial(int power, int coefficient) {
        // Call Default Constructor
        this();
        
        // Check if power is less than 0, throw IllegalArgumentException exception
        if (power < 0) 
        {
            throw new IllegalArgumentException("Power number in Polynomial cannot be negative.");
        }

        // Else create one "term" variable for Polynomial class using the 2 parameters
        this.terms.put(power, coefficient);
    }

    /** Third Overloaded Constructor 
    * Constructs a new polynomial with a TreeMap as a parameter.
    * It must first call the default constructor to create an empty polynomial.
    * Then, it must find the maximum power from the TreeMap given and set the degree of the
    * polynomial. You can use the keyset method of the TreeMap class for this purpose.
    * Then, Using a loop, it adds the terms from the TreeMap into the polynomial.
    * For any element of the TreeMap, if the power value is negative, it must throw an
    * IllegalArgumentException exception with a proper message.
    * @param p a TreeMap including the powers and corresponding coefficients (Integer, Integer)
    */
    // Third Constructor
    public Polynomial(Map<Integer, Integer> p) {
        // Call Default Constructor
        this();

        // Since the 'power' variable is in the key element, loop the new 'power' variable in the Map's keySet using the Enchanced loop
        for (int power : p.keySet()) 
        {
            // Check if power is less than 0, throw IllegalArgumentException exception
            if (power < 0) 
            {
                throw new IllegalArgumentException("Power number in Polynomial cannot be negative.");
            }

            // Find max power from TreeMap to set the 'degree' of Polynomial
            if (power > this.degree) 
            {
                this.degree = power;
            }

            // Add a new term based on the 'power' key variable of the TreeMap
            terms.put(power, p.get(power));
        }
    }

    /** Fourth Overloaded Constructor (Copy Constructor)
    * Copy Constructor (The new polynomial is a separate copy of an existing polynomial.)
    * It has a polynomial, p, as one parameter.
    * It must create the new polynomial by copying the polynomial given as the parameter.
    * Use the method putAll to copy all the terms of the existing polynomial to the new one.
    * @param p an existing polynomial as the source to be copied to the new one
    */
    // Copy Constructor
    public Polynomial(Polynomial p) {
        // Call Default Constructor
        this();

        // Use the method putAll to copy all the terms of the existing polynomial to the new one.
        this.terms.putAll(p.terms);
    }

    /** Method Name: add
    * This method gets a polynomial, p, as a parameter, and adds its terms to the existing
    * polynomial, and updates the polynomial degree, if needed.
    * Adds the polynomial such that the terms are in order from highest power to lowest one.
    * Remember to have no two terms with the same power in the polynomial.
    * @param p the polynomial to add
    */
    // Method to add another Polynomial
    public void add(Polynomial p) 
    {
        // Since the 'power' variable is in the key element, loop the new 'power' variable in the Map's keySet using the Enchanced loop
        for (int power : p.terms.keySet()) 
        {
            // Get 'coefficient' of the 'p' Polynomial by getting the value maps to a specific key
            int coefficient = p.terms.get(power);
            
            // If the 2 terms has the same key (power) then combine the 2 value (coefficients)
            if (this.terms.containsKey(power)) 
            {
                this.terms.put(power, this.terms.get(power) + coefficient);
            } 
            else // else just add them normally 
            {
                this.terms.put(power, coefficient);
            }

            // Find max power from TreeMap to set the 'degree' of Polynomial
            if (power > this.degree) 
            {
                this.degree = power;
            }
        }
    }

    /** Method Name: add (Overloaded)
    * This static method gets two polynomials, p1 and p2, as the parameters.
    * Then, it creates a new polynomial by adding two existing polynomials, stores into the new
    * one, and returns it.
    * You must use the add method you have previously developed to prevent any redundant code in
    * this method.
    * @param p1 the first existing polynomial
    * @param p2 the second existing polynomial
    * @return a new polynomial which is the summation of the two polynomials p1 and p2
    */
    // Overloaded add method
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        // Create a new Polynomial which copy from Polynomial p1
        Polynomial p3 = new Polynomial(p1);

        // Use the add() method to add p2 into p1
        p3.add(p2);
        
        return p3;
    }

    // Method to subtract another Polynomial
    public void subtract(Polynomial polynomial) {
        for (int power : polynomial.terms.keySet()) {
            int coefficient = polynomial.terms.get(power);
            if (terms.containsKey(power)) {
                terms.put(power, terms.get(power) - coefficient);
            } else {
                terms.put(power, -coefficient);
            }
            degree = Math.max(degree, power);
        }
    }

    // Overloaded subtract method
    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial(p1);
        result.subtract(p2);
        return result;
    }

    // Method to get the degree of the polynomial
    public int getDegree() {
        return degree;
    }

    // Method to get the coefficient of a term
    public int coefficient(int power) {
        return terms.getOrDefault(power, 0);
    }

    // Method to change coefficient of a term
    public void changeCoefficient(int power, int newCoefficient) {
        if (terms.containsKey(power)) {
            terms.put(power, newCoefficient);
        }
    }

    // Method to remove a term
    public void removeTerm(int power) {
        terms.remove(power);
        updateDegree();
    }

    // Method to evaluate the polynomial for a given value
    public double evaluate(double x) {
        double result = 0;
        for (int power : terms.keySet()) {
            result += terms.get(power) * Math.pow(x, power);
        }
        return result;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Polynomial)) {
            return false;
        }
        Polynomial other = (Polynomial) obj;
        return terms.equals(other.terms);
    }

    // Override compareTo method
    @Override
    public int compareTo(Polynomial other) {
        if (evaluate(0) > other.evaluate(0)) {
            return 1;
        } else if (evaluate(0) < other.evaluate(0)) {
            return -1;
        } else {
            return 0;
        }
    }

    // Override toString method
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("P(x) = ");
        boolean firstTerm = true;
        for (int power : terms.keySet()) {
            int coefficient = terms.get(power);
            if (coefficient != 0) {
                if (!firstTerm && coefficient > 0) {
                    builder.append(" + ");
                }
                if (coefficient < 0) {
                    builder.append(" - ");
                    coefficient = -coefficient;
                }
                if (coefficient != 1 || power == 0) {
                    builder.append(coefficient);
                }
                if (power > 0) {
                    builder.append("x");
                    if (power > 1) {
                        builder.append("^").append(power);
                    }
                }
                firstTerm = false;
            }
        }
        return builder.toString();
    }
}
