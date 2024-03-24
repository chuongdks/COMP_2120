/*
charityDonations is a HashMap with String key type and Integer value type, representing the name of a donor and the amount of a donation. Integer dataCount is read from input. Complete the for loop to read dataCount strings from input. For each string read, if the string is a key in charityDonations:

    Output "Removing entry: " followed by the key, "->", and the value associated with the key.
    Remove the map entry for that key.

Ex: If the input is:

2
Ben Rob

then one possible output is:

Removing entry: Rob->180
charityDonations has:
Key: Jen, Value: 170
Key: Val, Value: 225
 */
import java.util.Scanner;
import java.util.HashMap;

public class CharityDonations {
   public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HashMap<String, Integer> charityDonations = new HashMap<String, Integer>();
        String donorName;
        int giftValue;
        int dataCount;
        int i;

        charityDonations.put("Rob", 180);
        charityDonations.put("Jen", 170);
        charityDonations.put("Val", 225);

        dataCount = scnr.nextInt();
        for (i = 0; i < dataCount; ++i) 
        {
            /* Your code goes here */
            donorName = scnr.next();

            if (charityDonations.containsKey(donorName)) 
            {
                // Output the entry being removed
                System.out.println("Removing entry: " + donorName + "->" + charityDonations.get(donorName));
                // Remove the entry from the HashMap
                charityDonations.remove(donorName);
            }			
        }

        if (charityDonations.keySet().size() > 0) 
        {
            System.out.println("charityDonations has:");
            // For each key in the HashMap, retrieve the value associated with the key
            for (String key : charityDonations.keySet()) 
            {
            System.out.println("Key: " + key + ", Value: " + charityDonations.get(key));
            }
        }
        else 
        {
            System.out.println("charityDonations is empty");
        }
    }
}