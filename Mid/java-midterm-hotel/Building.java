import java.time.*;
public class Building {
   private Year year;
   private int numFloors;

   public Building(){
    this.year = Year.now();
    this.numFloors = 1;
   }

   public Building(Year year, int floors){
    this.year = year;
    this.numFloors = floors;
   }
}
    
