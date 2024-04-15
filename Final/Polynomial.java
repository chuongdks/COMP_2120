/************************* Class Name: Polynomial.java ************************/
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

    /**                     Default Constructor
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

    /**                     Second Overloaded Constructor
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
        try
        {
            if (power < 0) 
            {
                throw new IllegalArgumentException("Power of a term can't be negative. The term ignored.");
            }
            // Create one "term" variable for Polynomial class using the 2 parameters
            this.terms.put(power, coefficient);
            this.degree = power; // Do we even need this lol
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**                     Third Overloaded Constructor 
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
            try
            {
                if (power < 0) 
                {
                    throw new IllegalArgumentException("Power of a term can't be negative. The term ignored.");
                }

                // Find max power from TreeMap to set the 'degree' of Polynomial
                if (power > this.degree) 
                {
                    this.degree = power;
                }

                // Add a new term based on the 'power' key variable of the TreeMap
                terms.put(power, p.get(power));                
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                this.removeTerm(power);
            }
        }
    }

    /**                     Fourth Overloaded Constructor (Copy Constructor)
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
        this.degree = p.degree;
    }

    /**                     Method Name: add
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

    /**                     Method Name: add (Overloaded)
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
    public static Polynomial add(Polynomial p1, Polynomial p2) 
    {
        // Create a new Polynomial which copy from Polynomial p1
        Polynomial p3 = new Polynomial(p1);

        // Use the add() method to add p2 into p1
        p3.add(p2);

        return p3;
    }

    /**                     Method Name: subtract
    * This method subtracts the polynomial p from the existing one.
    * A simple way is to create a new polynomial from the parameter, polynomial p, and change
    * the powers of all its terms to their corresponding negative values. Then add this
    * polynomial to the existing one.
    * @param p the polynomial to subtract
    */
    // Method to subtract another Polynomial
    public void subtract(Polynomial p) 
    {
        // Since the 'power' variable is in the key element, loop the new 'power' variable in the Map's keySet using the Enchanced loop
        for (int power : p.terms.keySet()) 
        {
            // Get 'coefficient' of the 'p' Polynomial by getting the value maps to a specific key
            int coefficient = p.terms.get(power);
            
            // If the 2 terms has the same key (power) then combine the 2 value (coefficients)
            if (this.terms.containsKey(power)) 
            {
                this.terms.put(power, this.terms.get(power) - coefficient);
            } 
            else // else just add them normally but change the value (coefficients) to negative
            {
                this.terms.put(power, -coefficient);
            }

            // Find max power from TreeMap to set the 'degree' of Polynomial
            if (power > this.degree) 
            {
                this.degree = power;
            }
        }        
    }

    /**                     Method Name: subtract (Overloaded)
    * This static method will get two polynomials, p1 and p2, subtract p2 from p1, and return
    * the result as a polynomial.
    * Use the subtract method that you have previously developed to prevent any redundant code.
    * @param p1 the first existing polynomial
    * @param p2 the second existing polynomial
    * @return a polynomial which is the result of the subtraction of p2 from p1
    */
    // Overloaded subtract method
    public static Polynomial subtract(Polynomial p1, Polynomial p2) 
    {
        // Create a new Polynomial which copy from Polynomial p1
        Polynomial p3 = new Polynomial(p1);

        // Use the add() method to add p2 into p1
        p3.subtract(p2);

        return p3;        
    }

    /**                     
    * Method Name: multiply
    * This method multiplies the implicit parameter polynomial with another polynomial given as a parameter.
    * It creates a new polynomial to store the result of the multiplication.
    * @param p the polynomial to multiply with
    * @return a new polynomial which is the result of the multiplication
    */
    public Polynomial multiply(Polynomial p) {
        // Create a new polynomial to store the result
        Polynomial result = new Polynomial();

        // Iterate through each term of the implicit parameter polynomial
        for (int power1 : this.terms.keySet()) 
        {
            int coefficient1 = this.terms.get(power1);

            // Iterate through each term of the parameter polynomial
            for (int power2 : p.terms.keySet()) 
            {
                int coefficient2 = p.terms.get(power2);

                // Multiply the coefficients and add the powers
                int newCoefficient = coefficient1 * coefficient2;
                int newPower = power1 + power2;

                // Add the term to the result polynomial
                result.terms.put(newPower, result.terms.getOrDefault(newPower, 0) + newCoefficient); //getOrDefault(key, defaultValue) get the value mapped with specific key, if not found then return default value
                /*
                 * Alternatively, you could do this:
                result.terms.put(newPower, result.terms.containsKey(newPower) ? result.terms.get(newPower) + newCoefficient : newCoefficient);
                */

                // Update the degree of the result polynomial if necessary
                if (newPower > result.degree) 
                {
                    result.degree = newPower;
                }
            }
        }

        return result;
    }

    /**                     Method Name: getDegree
    * This method returns the degree of an existing polynomial (implicit parameter).
    * @return degree of the polynomial
    */
    // Getter method to get the degree of the polynomial
    public int getDegree() 
    {
        return this.degree;
    }

    /**                     Method Name: coefficient
    * This method returns the coefficient of the term, corresponding to the power given, of the
    * existing polynomial (implicit parameter).
    * You can use the method keyset for this purpose.
    * @param power the term's power
    * @return an integer which is the coefficient of the term with the corresponding power
    */
    // Getter Method to get the coefficient of a term
    public int coefficient(int power) 
    {
        return this.terms.get(power);
    }

    /**                     Method Name: changeCoefficient
    * This method changes the coefficient of a term in the existing polynomial (implicit
    * parameter), corresponding to the power, given as the first parameter, with a new
    * coefficient, given as the second parameter. You can use keySet method for this purpose.
    * @param power the term's power
    * @param newCoefficient the new value of the coefficient
    */
    // Method to change coefficient of a term
    public void changeCoefficient(int power, int newCoefficient) 
    {
        if (this.terms.containsKey(power)) 
        {
            this.terms.put(power, newCoefficient);
        }
    }

    /**                     Method Name: removeTerm
    * This method removes an existing term from the existing polynomial (implicit parameter).
    * @param power the term's power
    */
    // Method to remove a term
    public void removeTerm(int power) 
    {
        if (this.terms.containsKey(power)) 
        {
            this.terms.remove(power);
        }
    }

    /**                     Method Name: evaluate
    * This method evaluates the existing polynomial (implicit parameter) using a value, x, given
    * as a parameter.
    * @param x the value the polynomial must be evaluated for
    * @return The value of the polynomial at the given value, x
    */
    // Method to evaluate the polynomial for a given value
    public double evaluate(double x) 
    {
        double result = 0;
        for (int power : this.terms.keySet()) 
        {
            result += this.terms.get(power) * Math.pow(x, power); // Coefficient * (x ^ Power)
        }
        return result;
    }

    /**                     Method Name: equals
    * Override the equals method. Two polynomials are equal if all their terms are equal.
    * You must follow the correct method signature for this job.
    */    
    // Override equals method, not sure if taught in zyBook yet, use this https://www.geeksforgeeks.org/overriding-equals-method-in-java/
    @Override
    public boolean equals(Object obj) 
    {
        // If the object is compared with itself then return true  
        if (this == obj) 
        {
            return true;
        }
        // Check if object is an instance of Polynomial or not. "null instanceof [type]" also returns false 
        if (!(obj instanceof Polynomial)) 
        {
            return false;
        }

        // typecast object to Polynomial so that we can compare data members 
        Polynomial other = (Polynomial) obj;

        // Compare the data members and return accordingly 
        return this.terms.equals(other.terms);
    }

    /**                     Method Name: compareTo
    * Override the compareTo method, based on the evaluation of two polynomials with value 0.
    */    
    // Override compareTo method using evaluate() method
    @Override
    public int compareTo(Polynomial other) 
    {
        // return 1 if 𝑝(0) > 𝑞(0)
        if (this.evaluate(0) > other.evaluate(0)) 
        {
            return 1;
        } 
        // return -1 if 𝑝(0) < 𝑞(0)
        else if (this.evaluate(0) < other.evaluate(0)) 
        {
            return -1;
        } 
        // return 0 if 𝑝(0) = 𝑞(0)
        else 
        {
            return 0;
        }
    }

    /**                     Method Name: toString
    * Override the toString method.
    * You must follow the correct method signature for this job.
    * For instance, the polynomial 𝑝(𝑥) = 3𝑥^4 + 𝑥^2 − 4𝑥 + 5
    * will be shown as P(x) = 3x4 + x2 – 4x + 5
    */
    // Override toString method
    @Override
    public String toString() 
    {
        String polynomialString = ""; // Polynomial String
        boolean maxPowerTerm = true; // Check if a term is the biggest term

        // Get individual Key (Power)
        for (int power : this.terms.keySet()) 
        {
            // Get individual Value (Coefficient)
            int coefficient = this.terms.get(power);

            // If the Coefficient is 0 then dont write it
            if (coefficient != 0) 
            {
                // If not max Term and the Coefficient is > 0, add '+' sign
                if (!maxPowerTerm && coefficient > 0) 
                {
                    polynomialString += " + ";
                }

                // If the Coefficient is < 0, add '-' sign
                if (coefficient < 0) 
                {
                    polynomialString += " - ";
                    coefficient = -coefficient;
                }

                // Number printing, if Coefficient is not 1 or the Power is 0, just print the Coefficient number. Ex: x^2 or 5x^0 = 5
                if (coefficient != 1 || power == 0) 
                {
                    polynomialString += Integer.toString(coefficient);
                }

                // Number printing, if the Powah is > 0, add the letter 'x' and if it is > 1, print the power number. Ex: x3 or x^1 = x
                if (power > 0) 
                {
                    polynomialString += "x";
                    if (power > 1) 
                    {
                        polynomialString += Integer.toString(power);
                    }
                }
                maxPowerTerm = false; // Since the TreeMap is in reverse order, the max Term is always the first Term, so set false after first iteration
            }
        }
        return polynomialString;
    }
}
