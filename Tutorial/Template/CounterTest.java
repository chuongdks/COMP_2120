public class CounterTest {
    //Main() method
    public static void main(String[] args) {
        final int MAX_COUNTER_CAPACITY = 200;
        //Create an instance object of class Counter
        Counter ER1118 = new Counter(19, MAX_COUNTER_CAPACITY); //Implicitly call the Contructor method
        ER1118.increment();
        ER1118.increment();
        ER1118.increment();
        System.out.println ("ER1118 counter: " + ER1118.getValue());
        System.out.println ("ER1118 capacity: " + ER1118.getCapacity());

        Counter ER2126 = new Counter(30, 120);
        ER2126.increment();
        System.out.println ("ER2126 counter: " + ER2126.getValue());
        System.out.println ("ER2126 capacity: " + ER2126.getCapacity());

        Counter EmptyRoom = new Counter();
        ER2126.increment();
        System.out.println ("ER2126 counter: " + ER2126.getValue());
        System.out.println ("ER2126 capacity: " + ER2126.getCapacity());
    }
}
