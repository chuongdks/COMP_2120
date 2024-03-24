/*
singularToPlural is a HashMap with String key type and String value type. Each entry in singularToPlural associates an irregular word's singular form with the word's plural form. Integer numData is read from input. Then numData pairs of strings are read from input and inserted into singularToPlural. Complete the following tasks:

    Read string singularWord from input.
    If singularWord is an irregular word in singularToPlural, output "I love " followed by singularWord's associated plural form.
    Otherwise, output "I love " followed by the string and "s".

End with a newline.

Ex: If the input is:

4
jelly jellies peach peaches potato potatoes squash squashes
squash

then the output is:

I love squashes

 */

import java.util.Scanner;
import java.util.HashMap;

public class FoodWords {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HashMap<String, String> singularToPlural = new HashMap<String, String>();
        String singularWord;
        int numData;
        int i;

        numData = scnr.nextInt();
        for (i = 0; i < numData; ++i) 
        {
            singularToPlural.put(scnr.next(), scnr.next());
        }

        singularWord = scnr.next();

        // Check if the singular word is irregular in singularToPlural
        if (singularToPlural.containsKey(singularWord)) 
        {
            // Output the associated plural form
            System.out.println("I love " + singularToPlural.get(singularWord));
        } 
        else 
        {
            // Output the singular word followed by "s"
            System.out.println("I love " + singularWord + "s");
        }
    }
}
