import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;

public class Airport {
    // Instance variables
    private Queue<String> takeOffQueue; // FIFO with Priority
    private Queue<String> landingQueue; // FIFO
    private Stack<String> activityLog; // LIFO

    // Default constructor
    public Airport() {
        this.takeOffQueue = new PriorityQueue<>(); // cannot use Quese name = new Queue<>(); cuz Queue is an Interface, you cant instantiated interface directly
        this.landingQueue = new LinkedList<>();
        this.activityLog = new Stack<>();
    }

    // Method to add airplane to take-off queue
    public void addTakeOff(String flightId) // t flightID
    {
        takeOffQueue.add(flightId);
    }

    // Method to add airplane to landing queue
    public void addLanding(String flightId) // l flightID
    {
        landingQueue.add(flightId);
    }

    // Method to handle next take-off or landing operation
    public String handleNextAction() // n
    {
        String nextActionString = ""; // Operation String showing the Landing or Takeoff

        // Check if there are airplanes waiting to take-off
        if (landingQueue.peek() != null) // or !takeOffQueue.isEmpty()
        {
            String flightId = landingQueue.poll();
            activityLog.push("Flight" + flightId + " landed.");
            nextActionString += "Flight" + flightId + " is landing.\n";            
        }
        // If no take-off, check if there are airplanes waiting to land
        else if (takeOffQueue.peek() != null)  // or !landingQueue.isEmpty()
        {
            String flightId = takeOffQueue.poll();
            activityLog.push("Flight" + flightId + " taken-off");
            nextActionString += "Flight" + flightId + " is taking off.\n";              
        }
        else if (landingQueue.peek() == null && takeOffQueue.peek() == null)  // or !landingQueue.isEmpty()
        {
            nextActionString += "No plane is waiting to land or take off\n";              
        }        
        return nextActionString;
    }

    // Method to get list of waiting airplanes
    public String waitingPlanes() // p
    {
        String waitList = ""; 

        if (landingQueue.peek() != null) // or !landingQueue.isEmpty()
        {
            waitList += "Planes waiting for landing\n"; 
            waitList += "---------------------------\n"; 
            for (String flightId : landingQueue)
            {
                waitList += "" + flightId + "\n";
            }
        }

        if (takeOffQueue.peek() != null)  // or !takeOffQueue.isEmpty()
        {
            waitList += "Planes waiting for take-off\n"; 
            waitList += "---------------------------\n"; 
            for (String flightId : takeOffQueue)
            {
                waitList += "" + flightId + "\n";
            }
        }

        // Check if there are airplanes waiting to take-off
        if (takeOffQueue.peek() == null && landingQueue.peek() == null) // or !takeOffQueue.isEmpty()
        {
            waitList += "No plane is in the landing and take-off queues.\n";
        }        
        return waitList;
    }

    // Method to get activity log
    public String log() // g
    {
        String activityLogString = "";

        Stack<String> reversedLog = new Stack<>(); // Create a temporary stack
        // Reverse the order of elements in the activityLog stack
        while (!activityLog.isEmpty()) // or  activityLog.peek() != null but using it will cause Java to throw Exception when the Stack is empty in the beginning
        {
            reversedLog.push(activityLog.pop());
        }
        
        if (!reversedLog.isEmpty() ) // or reversedLog.peek() != null
        {
            activityLogString += "List of the landing/take-off activities\n"; 
            activityLogString += "---------------------------------------\n";             
            for (String flightLog : reversedLog) 
            {
                activityLogString += flightLog + "\n";
            }
        } 
        else 
        {
            activityLogString += "No activity exists.\n";
        }
        
        // Restore the original order of elements in the activityLog stack
        while (!reversedLog.isEmpty()) // or reversedLog.peek() != null
        {
            activityLog.push(reversedLog.pop());
        }
        
        return activityLogString;
    }

    // Overloaded method to write activity log to a text file
    public void log(String filename) // f
    {
        try (PrintWriter outFS = new PrintWriter(new FileOutputStream(filename)))
        {
            // Pop the activityLog Stack into the file
            while (!activityLog.isEmpty()) 
            {
                outFS.println(activityLog.pop());
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        // outFS.close();
    }
}
