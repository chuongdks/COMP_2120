/*

Variable usersQueue is a Queue of type String. Strings are read from input and are added to usersQueue until "end" is read. Complete the loop to remove and output the element at the head of usersQueue while both of the following conditions are true:

    usersQueue is not empty.
    The value at the head of usersQueue is not equal to "Noa".

Ex: If the input is Taj Ava Jen Noa end, then the output is:

User passed: Taj
User passed: Ava
User passed: Jen
Alert: Noa has not passed yet

 */
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class FirstInUsersQueue {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Queue<String> usersQueue = new LinkedList<String>();
        String userValue;

        userValue = scnr.next();
        while (!userValue.equals("end")) 
        {
            usersQueue.add(userValue);
            userValue = scnr.next();
        }

        while (!usersQueue.isEmpty() && !usersQueue.peek().equals("Noa")) 
        {
            System.out.println("User passed: " + usersQueue.poll());
        }

        if (usersQueue.peek() == null) 
        {
            System.out.println("All users passed");
        }
        else 
        {
            System.out.print("Alert: " + usersQueue.peek());
            System.out.println(" has not passed yet");
        }
    }
}