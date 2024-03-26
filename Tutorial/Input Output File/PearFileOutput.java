import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class PearFileOutput {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      String dataFileName;
      double pearQuantity;
      FileOutputStream fileStream = null;
      PrintWriter dataWriter = null;      

      dataFileName = scnr.next();

      /* Your code goes here */
      fileStream = new FileOutputStream(dataFileName);
      dataWriter = new PrintWriter(fileStream);
      
      pearQuantity = scnr.nextDouble();

      dataWriter.println(pearQuantity + " kilograms of pears");
      dataWriter.close();
   }
}