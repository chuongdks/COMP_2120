import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class InputFromFile {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String fileName;
        String violinistName;
        /* Variable declarations go here */
        FileInputStream fByteStream = null;
        Scanner inFS = null;

        fileName = scnr.next();

        fByteStream = new FileInputStream(fileName);
        inFS = new Scanner(fByteStream);

        violinistName = inFS.next();
        System.out.println(violinistName);

        fByteStream.close();
    }
}