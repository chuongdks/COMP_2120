public class StatePair<Type1 extends Comparable<Type1>, Type2 extends Comparable<Type2>> {
    private Type1 value1;
    private Type2 value2;

    // Constructor Method
    public StatePair(Type1 value1, Type2 value2) 
    {
        this.value1 = value1;
        this.value2 = value2;
    }

    // Accessors Method
    public Type1 getValue1() 
    {
        return value1;
    }

    public Type2 getValue2() 
    {
        return value2;
    }

    // Mutators Method
    public void setValue1(Type1 value1) 
    {
        this.value1 = value1;
    }

    public void setValue2(Type2 value2) 
    {
        this.value2 = value2;
    }

    // printInfo Method
    public void printInfo() 
    {
        System.out.println("Value 1: " + value1 + ", Value 2: " + value2);
    }
}
