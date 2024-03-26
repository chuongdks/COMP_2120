/*
String dataFileName is read from input. The opened file, dataFileName, contains the number of couches sold by a furniture store, and is associated with Scanner inFS. Write a while loop that iterates until no valid integer is available from the file. In each iteration of the loop:

    Read an integer from the opened file.
    Output the integer read.

End each output with a newline.

Click here for example
Ex: If the input is data4.txt and:

Data in file data4.txt
37


then the output is:

37
Reached end of file
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReading {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      FileInputStream fileByteStream = null;
      Scanner inFS = null;
      String dataFileName;
      int couchCount;

      dataFileName = scnr.next();

      fileByteStream = new FileInputStream(dataFileName);
      inFS = new Scanner(fileByteStream);

      /* Your code goes here */
      while (inFS.hasNextInt()) 
      {
         couchCount = inFS.nextInt();
         System.out.println(couchCount);
      }
      
      if (inFS.hasNext()) {
         System.out.println("Reading stopped at " + inFS.next());
      }
      else {
         System.out.println("Reached end of file");
      }

      fileByteStream.close();
   }
}