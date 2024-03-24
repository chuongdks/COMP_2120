/* 

11.5 LAB: Zip code and population (generic types)

Define a class StatePair with two generic types (Type1 and Type2), a constructor, mutators, accessors, and a printInfo() method. Three ArrayLists have been pre-filled with StatePair data in main():

    ArrayList<StatePair<Integer, String>> zipCodeState: Contains ZIP code/state abbreviation pairs
    ArrayList<StatePair<String, String>> abbrevState: Contains state abbreviation/state name pairs
    ArrayList<StatePair<String, Integer>> statePopulation: Contains state name/population pairs

Complete main() to use an input ZIP code to retrieve the correct state abbreviation from the ArrayList zipCodeState. Then use the state abbreviation to retrieve the state name from the ArrayList abbrevState. Lastly, use the state name to retrieve the correct state name/population pair from the ArrayList statePopulation and output the pair.

Ex: If the input is:

21044

the output is:

Maryland: 6079602

*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StatePopulations {

   // Function that has return type of an ArrayList of StatePair, which has parameter of an ArrayList of StatePairs and Scanner
   public static ArrayList<StatePair<Integer, String>> fillArray1(ArrayList<StatePair<Integer, String>> statePairs, Scanner inFS) 
   {
      StatePair<Integer, String> pair;
      int intValue;
      String stringValue;

      while (inFS.hasNextLine()) 
      {
         intValue = inFS.nextInt();
         stringValue = inFS.next();
         pair = new StatePair<Integer, String> (intValue, stringValue);
         statePairs.add(pair);
      }    
      return statePairs;
   }
   
   public static ArrayList<StatePair<String, String>> fillArray2(ArrayList<StatePair<String, String>> statePairs, Scanner inFS) 
   {
      StatePair<String, String> pair;
      String stringValue1;
      String stringValue2;

      while (inFS.hasNextLine()) 
      {
         stringValue1 = inFS.next();
         inFS.nextLine();
         stringValue2 = inFS.nextLine();
         pair = new StatePair<String, String> (stringValue1, stringValue2);
         statePairs.add(pair);
      }
      return statePairs;
   }
   
   public static ArrayList<StatePair<String, Integer>> fillArray3(ArrayList<StatePair<String, Integer>> statePairs, Scanner inFS) {
      StatePair<String, Integer> pair;
      String stringValue;
      int intValue;

      while (inFS.hasNextLine()) 
      {
         stringValue = inFS.nextLine();
         intValue = inFS.nextInt();
         inFS.nextLine();
         pair = new StatePair<String, Integer> (stringValue, intValue);
         statePairs.add(pair);
      } 
      return statePairs;
   }
   
   
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      FileInputStream fileByteStream = null; // File input stream
      Scanner inFS = null;                   // Scanner object
      int myZipCode;
      int i;
      
      // ZIP code - state abbrev. pairs
      ArrayList<StatePair<Integer, String>> zipCodeState = new ArrayList<StatePair<Integer, String>>();
      
      // state abbrev. - state name pairs
      ArrayList<StatePair<String, String>> abbrevState = new ArrayList<StatePair<String, String>>(); 
      
      // state name - population pairs
      ArrayList<StatePair<String, Integer>> statePopulation = new ArrayList<StatePair<String, Integer>>();
      
      /* Fill the three ArrayLists */
      
      // Try to open zip_code_state.txt file
      fileByteStream = new FileInputStream("zip_code_state.txt");
      inFS = new Scanner(fileByteStream);
      zipCodeState = fillArray1(zipCodeState, inFS);
      fileByteStream.close(); // close() may throw IOException if fails
      
      // Try to open abbreviation_state.txt file
      fileByteStream = new FileInputStream("abbreviation_state.txt");
      inFS = new Scanner(fileByteStream);
      abbrevState = fillArray2(abbrevState, inFS);
      fileByteStream.close();
      
      // Try to open state_population.txt file
      fileByteStream = new FileInputStream("state_population.txt");
      inFS = new Scanner(fileByteStream);
      statePopulation = fillArray3(statePopulation, inFS);
      fileByteStream.close();
      
      // Read in ZIP code from user
      myZipCode = scnr.nextInt();
      
      String stateAbbreviation = "";
      for (i = 0; i < zipCodeState.size(); ++i) 
      {
         // TODO: Using ZIP code, find state abbreviation
         if (zipCodeState.get(i).getValue1() == myZipCode) 
         {
            stateAbbreviation = zipCodeState.get(i).getValue2();
            break;
         }         
      }
      
      String stateName = "";
      for (i = 0; i < abbrevState.size(); ++i) 
      {
         // TODO: Using state abbreviation, find state name
         if (abbrevState.get(i).getValue1().equals(stateAbbreviation)) 
         {
            stateName = abbrevState.get(i).getValue2();
            break;
         }             
      }
      
      for (i = 0; i < statePopulation.size(); ++i) 
      {
         // TODO: Using state name, find population. Print pair info
         if (statePopulation.get(i).getValue1().equalsIgnoreCase(stateName))
         {
            statePopulation.get(i).printInfo() ;
            break;
         }        
      }
   }
}