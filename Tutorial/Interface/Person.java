import java.util.ArrayList;
// Person file
public class Person implements Measureable{   
    int age; 

    public Person(int age)
    {
        this.age = age;
    }

    @Override
    public int getMeasure()
    {
        return this.age;
    }

    public static void main(String[] args){
        ArrayList<Measureable> group = new ArrayList<Measureable>();

        Person p1 = new Person(2);
        Person p2 = new Person(2);
        Person p3 = new Person(2);
        group.add(p1);
        group.add(p2);
        group.add(p3);

        System.out.println(Measureable.average(group));
    }


}