import java.util.ArrayList;
import java.util.Scanner;

public class SeatReservation {

   // Arraylist for seat reservations based on the "Seat" Class
   private ArrayList<Seat> allSeats; // Has-a relationship

   // Constructor of SeatReservation to add an ArrayList of "Seat" Class
   public SeatReservation() {
       allSeats = new ArrayList<Seat>();
   }
   
   // Method to empty all Seats
   public void makeSeatsEmpty() 
   {
      for (int i = 0; i < allSeats.size(); ++i) 
      {
         allSeats.get(i).makeEmpty();
      }
   }

   // Method to empty a specific Seat
   // FIX ME: Add Method to make one seat empty
   public void makeOneSeatEmpty(int seatNum) 
   {
      // return allSeats.remove(seatNum); This line will just removed the Array in the Array Listand print this out instead System.out.println(ezReservations.getSeat(seatNum));
      allSeats.get(seatNum).makeEmpty();
   }

   // Method to print all Seats
   public void printSeats() 
   {
      for (int i = 0; i < allSeats.size(); ++i) 
      {
         System.out.print(i + ": ");
         allSeats.get(i).print();
      }
   }

   // Method to add Seats
   public void addSeats(int numSeats) 
   {
      for (int i = 0; i < numSeats; ++i) 
      {
         allSeats.add(new Seat()); // use the add() method of ArrayList, add a new Seat() object
      }
   }
   
   // Method to get seat's info based on seat's number 
   // Info came from the "Seat" Class, return a "Seat" Class type
   public Seat getSeat (int seatNum) 
   {
      return allSeats.get(seatNum); // use the get() method of ArrayList
   }   
   
   // Method to set seat number based on the "Seat" Class, return a "Seat" Class type
   public void setSeat(int seatNum, Seat newSeat) 
   {
      allSeats.set(seatNum, newSeat); 
   }

   // Main method to use SeatReservation methods
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      String usrInput = "";
      String firstName, lastName;
      int amountPaid;
      int seatNum;
      Seat newSeat;
      SeatReservation ezReservations = new SeatReservation();

      // Add 5 seat objects
      ezReservations.addSeats(5);

      // Make all seats empty
      ezReservations.makeSeatsEmpty();

      while (!usrInput.equals("q")) 
      {
         System.out.println();
         System.out.print("Enter command (p/r/q/d): ");
         usrInput = scnr.next();

         // Print seats
         if (usrInput.equals("p")) 
         { 
            ezReservations.printSeats();
         }
         // Reserve a seat
         else if (usrInput.equals("r")) 
         {
            System.out.print("Enter seat num: ");
            seatNum = scnr.nextInt();

            if ( !(ezReservations.getSeat(seatNum).isEmpty()) ) 
            {
               System.out.println("Seat not empty.");
            }
            else 
            {
               System.out.print("Enter first name: ");
               firstName = scnr.next();
               System.out.print("Enter last name: ");
               lastName = scnr.next();
               System.out.print("Enter amount paid: ");
               amountPaid = scnr.nextInt();

               // Create new Seat object and add to the reservations
               newSeat = new Seat();
               newSeat.reserve (firstName, lastName, amountPaid); 
               ezReservations.setSeat(seatNum, newSeat); 

               System.out.println("Completed.");
            }
         }
         // Quit
         else if (usrInput.equals("q")) 
         { 
            System.out.println("Quitting.");
         }
         // Delete specific seat
         else if (usrInput.equals("d")) 
         { 
            System.out.print("Enter seat num: ");
            seatNum = scnr.nextInt();

            
            if ( !(ezReservations.getSeat(seatNum).isEmpty()) ) 
            {
               ezReservations.makeOneSeatEmpty(seatNum);
               System.out.println("Seat not empty. Deleting seat: " +  seatNum);
            }
            else 
            {
               System.out.println("Seat is empty.");
            }            
         }
         else 
         {
            System.out.println("Invalid command.");
         }
      }
   }
}