import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOut{
    public static void main(String[] args) throws IOException {
        // Cteate an output file
        FileOutputStream myOutputFile = new FileOutputStream("test.txt"); // Open the file
        PrintWriter pw = new PrintWriter(myOutputFile);;

        // Write some numer to the file
        Scanner keyboardInput = new Scanner(System.in);
        int i;
        System.out.println("Enter some number here:");

        do 
        {
            i = keyboardInput.nextInt();
            if (i != 0)
            {
            pw.println(i);
            }
        } while (i != 0);

        // Done with file, so try to close
        // Note that close() may throw an IOException on failure
        pw.close();

        // Open the file to read
        FileInputStream myInputFile = new FileInputStream("test.txt");
        Scanner fileInput = new Scanner(myInputFile);
        System.out.println("The content of the file:");
        while (fileInput.hasNextInt())
        {
            System.out.println(fileInput.nextInt());
        }

        // Close the file
        myInputFile.close();
   }
}