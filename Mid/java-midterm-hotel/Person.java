public class Person {
    private String firstName;
    private String lastName;

    public Person(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}
