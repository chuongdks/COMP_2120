public class Generics{
    /*
    Why u should use Generic 

    public static void printStringArray (String[] myArray)
    {
        for (String e:myArray)
        {
            System.out.println(e);
        }
    }

    public static void printIntegerArray (int[] myArray)
    {
        for (int e:myArray)
        {
            System.out.println(e);
        }
    }    
    
    */
    public static <T> void printArray (T[] myArray) // Can name whatever inside <>, conventionally use 'T'
    {
        for (T e:myArray)
        {
            System.out.println(e);
        }
    } 

    public static void main (String[] args){
        String[] s = new String[3];
        s[0] = "Test3";
        s[1] = "Test1";
        s[2] = "Test2";
        // printStringArray(s);
        printArray(s);

        Integer[] i = new Integer[4]; // Generic cannot use primitive type
        i[0] = 1;
        i[1] = 3;
        i[2] = 4;
        i[3] = 5;    
        // printIntegerArray(i);
        printArray(i);

        Person[] persons = new Person[2];
        person[0] = new Person("Chuong", 21);
        person[1] = new Person("Bob", 99);
        printArray(persons);
    }
}