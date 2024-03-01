import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PlantArrayListExample {

   // Define a printArrayList method that prints an ArrayList of plant (or flower) objects                                                       
   public void printArrayList (ArrayList<Plant> myGarden)
   {
      int counter = 1;
      for (Plant plant : myGarden) // Virgin enchance loop: Doesnt have index, need counter / Chad classic: understandable, has index
      {
         System.out.println("Plant " + counter +" Information: "); 
			plant.printInfo();     
			System.out.println("");   
			counter++;
		}
   }
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String input = "";

      // Declare an ArrayList called myGarden that can hold object of type plant
      ArrayList<Plant> myGarden = new ArrayList<Plant>();
      
      // Declare variables - plantName, plantCost, flowerName, flowerCost, colorOfFlowers, isAnnual
      Plant myPlant;
      Flower myFlower;
      
      String plantName, plantCost;
      String flowerName, flowerCost, colorOfFlowers;
      boolean isAnnual;
      
      while(!input.equals("-1")){
         // Check if input is a plant or flower
         //       Store as a plant object or flower object
         //       Add to the ArrayList myGarden
         input = scnr.next();
         
         if (input.equals("plant"))
         {
            myPlant = new Plant();
            
            plantName = scnr.next();
            plantCost = scnr.next();
            scnr.nextLine();
            
            myPlant.setPlantName(plantName);
            myPlant.setPlantCost(plantCost);
            
            myGarden.add(myPlant);
         }
         else if (input.equals("flower"))
         {
            myFlower = new Flower();
            
            flowerName = scnr.next();
            flowerCost = scnr.next();
            isAnnual = scnr.nextBoolean();
            colorOfFlowers = scnr.next();
            scnr.nextLine();
            
            myFlower.setPlantName(flowerName);
            myFlower.setPlantCost(flowerCost);
            myFlower.setColorOfFlowers(colorOfFlowers);
            myFlower.setPlantType(isAnnual);   
            
            myGarden.add(myFlower);
         }                      
      }
      
      // Call the method printArrayList to print myGarden
      PlantArrayListExample test = new PlantArrayListExample();
      test.printArrayList(myGarden);
   }
}
