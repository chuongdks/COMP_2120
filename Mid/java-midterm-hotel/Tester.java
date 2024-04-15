import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

public class Tester {
    
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // Create a 3.5 stars hotel, named "Baba-Mama", built in 2018, with two floors
        // The owners' "firstname last name"'s of the hotel are "Ali Baba" and "Alice Mama".
        
        ArrayList<Person> owners = new ArrayList<Person>();
        Year y = Year.of(2018);
        Hotel hotel = new Hotel("Hotel Baba-Mama", owners, y, 2, 3.5);
        hotel.addOwner(new Person("Ali", "Baba"));
        hotel.addOwner(new Person("Alice", "Mama"));
        
        // Adding some rooms to this new hotel
        // SINGLE, price=$35.50, size=200, floor=1, number=101, description="Single Room without view");
        Room r1 = new Room(Room.RoomType.SINGLE,200,1,101,"Single Room without view", true, new ArrayList<Reservation>());
        r1.setPrice(35.50);
        
        
        // Double, price=$50.50, size=350, floor=1, number=102, description="Double Room without view");
        Room r2 = new Room(Room.RoomType.DOUBLE,350,1,102,"Double Room without view", true, new ArrayList<Reservation>());
        r2.setPrice(50.50);
        
        
        // Double, price=$55.00, size=400, floor=2, number=201, description="Double Room with view");
        Room r3 = new Room(Room.RoomType.DOUBLE,400,2,201,"Double Room with view", true, new ArrayList<Reservation>());
        r3.setPrice(55.50);
        
        
        // Suite, price=80.00, size=500, floor=2, number=202, description="Suite Room with view and balcony");
        Room r4 = new Room(Room.RoomType.SUITE,500,2,202,"Suite Room with view and balcony", true, new ArrayList<Reservation>());
        r4.setPrice(80.00);

        hotel.addRoom(r1);
        hotel.addRoom(r2);
        hotel.addRoom(r3);
        hotel.addRoom(r4);
        
        
        // Show the hotel information, including its rooms
        System.out.println(hotel.toString());
        
        // Reserve the room number 102 for "Joe Uncle", checkin March 6, 2021, checkout March 8, 2021
        int res1 = hotel.reserve(102, new Date(2021-1900, 3-1, 6), new Date(2021-1900, 3-1,8), new Person("Joe","Uncle"));
        // Print out the reservation result
        
        ArrayList<Reservation> resList102 = hotel.getRoom(102).getReservations();
        for(Reservation r : resList102){
            if(r.getResNum() == res1){
                System.out.println(r.toString());
            }
        }
        
        
        
        
        // Change the price of the room 102 to $52.00
        hotel.getRoom(102).setPrice(52);
        
        // Reserve the room number 102 for "Mike Brother", checkin April 2, 2021, checkout April 4, 2021
        int res2 = hotel.reserve(102, new Date(2021-1900, 4-1, 2), new Date(2021-1900, 4-1,4), new Person("Mike","Brother"));

        // Print out the reservation result
        resList102 = hotel.getRoom(102).getReservations();
        for(Reservation r : resList102){
            if(r.getResNum() == res2){
                System.out.println(r.toString());
            }
        }
        
        
        
        
        
        
        // Reserve the room number 101 for "Maria Aunt", checkin May 27, 2021, checkout May 28, 2021
        // Print out the reservation result
        int res3 = hotel.reserve(101, new Date(2021-1900, 5-1, 27), new Date(2021-1900, 5-1,28), new Person("Maria","Aunt"));
        resList102 = hotel.getRoom(101).getReservations();
        for(Reservation r : resList102){
            if(r.getResNum() == res3){
                System.out.println(r.toString());
            }
        }
        
        
        
        
        
        
        // Reserve the room number 101 for "laura Sister", checkin May 25, 2021, checkout May 28, 2021
        // Print out the reservation result
        int res4 = hotel.reserve(101, new Date(2021-1900, 5-1, 25), new Date(2021-1900, 5-1,28), new Person("laura","Sister"));
        resList102 = hotel.getRoom(101).getReservations();
        for(Reservation r : resList102){
            if(r.getResNum() == res4){
                System.out.println(r.toString());
            }
        }
        
        
        
        
        
        
        // Check in the room 102
        
        
        // Cancel reservation number 10003 and show the cancellation result

        
        
        
        
        // Show all the statuses of all the rooms





    }
}
