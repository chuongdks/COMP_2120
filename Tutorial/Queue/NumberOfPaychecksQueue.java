/*
Variable paychecksQueue is a Queue of type Integer. Integers are read from input and are added to paychecksQueue until -99 is read. While paychecksQueue is not empty, repeat the following:

    Remove the element at the head of paychecksQueue.
    If the element's value is greater than or equal to 80, then output "Paycheck delivered. Unpaid hour(s) returned to queue: " followed by the element minus 80, and insert the remainder to the tail of paychecksQueue.
    Otherwise, output the element followed by " hour(s): paycheck not delivered yet".

End each output with a newline.

Ex: If the input is 99 71 -99, then the output is:

Paycheck delivered. Unpaid hour(s) returned to queue: 19
71 hour(s): paycheck not delivered yet
19 hour(s): paycheck not delivered yet
Queue is empty
 */

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class NumberOfPaychecksQueue {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Queue<Integer> paychecksQueue = new LinkedList<Integer>();
        int paycheckValue;

        paycheckValue = scnr.nextInt();
        while (paycheckValue != -99) 
        {
            paychecksQueue.add(paycheckValue);
            paycheckValue = scnr.nextInt();
        }

        while (paychecksQueue.peek() != null) 
        {
            int currentPaycheck = paychecksQueue.poll();
            if (currentPaycheck >= 80) 
            {
                int unpaidHours = currentPaycheck - 80;
                System.out.println("Paycheck delivered. Unpaid hour(s) returned to queue: " + unpaidHours);
                paychecksQueue.add(unpaidHours); // Add the unpaid hours to the tail of the queue
            } 
            else 
            {
                System.out.println(currentPaycheck + " hour(s): paycheck not delivered yet");
            }      	
        }

        System.out.println("Queue is empty");
   }
}