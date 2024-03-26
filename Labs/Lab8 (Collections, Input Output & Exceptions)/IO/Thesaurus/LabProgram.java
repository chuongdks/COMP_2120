/*
Given a set of text files containing synonyms for different words, complete the main program to output the synonyms for a specific word. Each text file contains synonyms for the word specified in the file’s name, and each row within the file lists the word’s synonyms that begin with the same letter, separated by a space. The program reads a word and a letter from the user and opens the text file associated with the input word. The program then stores the contents of the text file into a two-dimensional array predefined in the program. Finally the program searches the array and outputs all the synonyms that begin with the input letter, one synonym per line, or a message if no synonyms that begin with the input letter are found.

Hints: Use ASCII values to map the row index of the array to the first letter of a word when storing the synonyms into the array. Ex: Index 0 to an 'a', index 25 to a 'z'. Assume all letters are in lowercase.

Ex: If the input of the program is:

educate c

the program opens the file educate.txt, which contains:

brainwash brief
civilize coach cultivate
develop discipline drill
edify enlighten exercise explain
foster
improve indoctrinate inform instruct
mature
nurture
rear
school
train tutor

then the program outputs:

civilize
coach
cultivate

Ex: If the input of the program is:

educate a

then the program outputs:

No synonyms for educate begin with a.
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
   public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        int NUM_CHARACTERS = 26;      // Maximum number of letters
        int MAX_WORDS = 10;           // Maximum number of synonyms per starting letter

        String[][] synonyms = new String[NUM_CHARACTERS][MAX_WORDS];  // Declare 2D array for all synonyms
        String[] words = new String[MAX_WORDS]; // The words of each input line, wtf does this do

        /* Type your code here. */
        boolean synonymFound = false;
        // Read word and letter input from the user
        String word = scnr.next();
        char letter = scnr.next().charAt(0);

        // Construct the filename
        String filename = word + ".txt";

        // Open the text file associated with the input word
        FileInputStream fileByteStream = new FileInputStream(filename);
        Scanner inFS = new Scanner(fileByteStream);    

        // Read synonyms from the file and store them in the array
        while (inFS.hasNextLine()) 
        {
            String line = inFS.nextLine();
            Scanner lineScanner = new Scanner(line); // Create a Scanner object for the current line
            char firstChar = line.charAt(0);

            if (firstChar == letter)
            {
            //index 0 to 'a', index 25 to 'z'
            int index = firstChar - 'a'; // Calculate the index based on the first character of the line
            int wordIndex = 0; // Index to store words in the array   
            synonymFound = true;

            // Iterate over each word in the line
            while (lineScanner.hasNext()) 
            {
                String wordInLine = lineScanner.next(); // Read the next word
                // synonyms[index][wordIndex] = wordInLine; // Store the word in the array, dont even need this lol
                System.out.println(wordInLine);
                // System.out.println(synonyms[index][wordIndex]);
                // wordIndex++;               
            }            
            }      
        }

        // Output message if no synonyms that begin with the input letter are found
        if (!synonymFound) 
        {
            System.out.println("No synonyms for " + word + " begin with " + letter + ".");
        } 
        /*
        * Why do we need to store index n stuff since once u found the line with the correct letter, just print all the words
        */
        // else 
        // {
        //    // Print the synonyms
        //    for (String synonym : synonyms[letter - 'a']) 
        //    {
        //       if (synonym != null) 
        //       {
        //          System.out.println(synonym);
        //       }
        //    }
        // }    

        // Close the file
        fileByteStream.close();      
   }
}

/*
 * Using Split
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        int NUM_CHARACTERS = 26; // Maximum number of letters
        int MAX_WORDS = 10; // Maximum number of synonyms per starting letter

        String[][] synonyms = new String[NUM_CHARACTERS][MAX_WORDS]; // Declare 2D array for all synonyms
        String[] words = new String[MAX_WORDS]; // The words of each input line

        // Read word and letter input from the user
        System.out.print("Enter a word: ");
        String word = scnr.next();
        System.out.print("Enter a letter: ");
        char letter = scnr.next().charAt(0);

        // Construct the filename
        String filename = word + ".txt";

        // Open the text file associated with the input word
        FileInputStream fileByteStream = new FileInputStream(filename);
        Scanner fileScanner = new Scanner(fileByteStream);

        // Read synonyms from the file and store them in the array
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] wordsInLine = line.split(" ");
            char firstChar = wordsInLine[0].charAt(0);
            int index = firstChar - 'a';
            for (int i = 0; i < wordsInLine.length; i++) {
                synonyms[index][i] = wordsInLine[i];
            }
        }

        // Search the array for synonyms that begin with the input letter
        int index = letter - 'a';
        boolean found = false;
        for (String synonym : synonyms[index]) {
            if (synonym != null && synonym.charAt(0) == letter) {
                System.out.println(synonym);
                found = true;
            }
        }

        // Output message if no synonyms that begin with the input letter are found
        if (!found) {
            System.out.println("No synonyms for " + word + " begin with " + letter + ".");
        }

        // Close the file
        fileByteStream.close();
    }
}

 */