import java.util.Scanner;

public class WordFrequency {

    /* Define your method here */
    public static int getWordFrequency (String[] wordsList, int listSize, String currWord) 
    {
        int frequency = 0;
        for (int i = 0; i < listSize; i++) 
        {
            if (wordsList[i].equalsIgnoreCase (currWord)) 
            {
                frequency++;
            }
        }
        return frequency;
    }
   
    public static void main(String[] args) {
        /* Type your code here. */
        Scanner scanner = new Scanner(System.in);

        // Read the number of words
        int listSize = scanner.nextInt();

        // Initialize an array to store the words
        String[] wordsList = new String[20];
        String currWord = null;

        // Read the words into the array
        for (int i = 0; i < listSize; i++) 
        {
            wordsList[i] = scanner.next();
        }

        // Output the words with their frequencies
        for (int i = 0; i < listSize; i++) 
        {
            currWord = wordsList[i];
            int frequency = getWordFrequency (wordsList, listSize, currWord);
            System.out.println(currWord + " " + frequency);
        }
   }
}
