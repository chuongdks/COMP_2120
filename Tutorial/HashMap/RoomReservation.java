/*
reservedRoom is a HashMap with String key type and Character value type, representing the name and room label of a guest. Integer numData is read from input. Then numData key-value pairs are read from input and inserted into reservedRoom. For each key in the HashMap, output "* " followed by the key and a newline.

Ex: If the input is:

2
Ava E Meg S

then one possible output is:

All keys found: 
* Ava
* Meg 
*/
import java.util.Scanner;
import java.util.HashMap;

public class RoomReservation {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HashMap<String, Character> reservedRoom = new HashMap<String, Character>();
        String guestName;
        char roomLabel;
        int numData;
        int i;

        numData = scnr.nextInt();
        for (i = 0; i < numData; ++i) 
        {
            guestName = scnr.next();
            roomLabel = scnr.next().charAt(0);
            reservedRoom.put(guestName, roomLabel);
        }

        System.out.println("All keys found: ");

        // Output each key preceded by "* "
        for (String key : reservedRoom.keySet()) 
        {
            System.out.println("* " + key);
        }
    }
}
