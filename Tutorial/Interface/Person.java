import java.util.ArrayList;
// Person file
public class Person implements Measureable{    
    private int age;
    ArrayList<Integer> groupAge = new ArrayList<Integer>();

    // Method to add an author
    public void addAge(int age) 
    {
        this.groupAge.add(age);
    }    

    @Override
    public int getMeasure()
    {
        return this.age;
    }

    public static void main(String[] args){
        groupAge.add(24);
        groupAge.add(23);
        groupAge.add(14);

        Measureable.Average(groupAge);
    }


}