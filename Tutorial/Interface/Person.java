import java.util.ArrayList;
// Person file
public class Person implements Measureable{    
    private int age;
    ArrayList<Integer> groupAge = new ArrayList<Integer>();

    // Method to add an age
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
        ArrayList<Measureable> measurableList = new ArrayList<>();

        Person canada = new Person();
        canada.addAge(24);
        canada.addAge(23);
        canada.addAge(14);

        // Assuming each Person instance is measurable based on their age
        measurableList.add(canada);

        Measureable.Average(measurableList);
    }


}