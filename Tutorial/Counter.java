//User input 2 times
public class Counter {
    //Fields variable
    public int val; //Only direct access while inside the class (No access from outside). Default (initial) by zero
                    //Use private will prevent Fields from being accessed outside of 'Counter' class
    private int capacity;
    private boolean IsEmpty;

    //Constructor of the Counter class
    public Counter ()
    {
        // this.val = 0;
        // this.capacity = 10;
        this (0, 10); // Use above or this line, 'this' can also be overloaded
        IsEmpty = true; 
    }

    public Counter (int val, int capacity) //overloading the constructor
    {
        this.val = val;
        this.capacity = capacity;
        if (this.val > 0)
            this.IsEmpty = false;
        else
            this.IsEmpty = true;
    }

    //Actions (Methods)
    public void increment () //Outsiders are allowed to call the methods
    {
        if (this.val < capacity)
        {
            this.val++;
        }
    }

    public void increment (int incVal) //Overload the function, if use increment(5) then the function increment by 5
    {
        if (this.val < capacity)
        {
            this.val += incVal;
        }
    }

    public void decrement () //Outsiders are allowed to call the method
    {
        if (this.val > 0)
        {
            this.val --;
        }
    }

    public void reset () //Outsiders are allowed to call the method
    {
        val = 0;
    }

    public int getValue () //Outsiders are allowed to call the method
    {
        return val;
    }

    public int getCapacity () //Outsiders are allowed to call the method
    {
        return capacity;
    }

    //Main() method, not good practice to put main in Class, create another file called ClassTester or sthing and put main there to test it

    // public static void main(String[] args) {
    //     //Create an instance object of class Counter
    //     //1. Declare a reference variable of the class Counter
    //     //2. Create and object of Counter class in memory
    //     //3. Refer ref variable to the obj
    //     Counter ER1118 = new Counter();
    //     System.out.println ("ER1118 counter: " + ER1118.val);

    //     int a = 0; //A local int variable in main method. It has no initial (default) value
    // }
}
