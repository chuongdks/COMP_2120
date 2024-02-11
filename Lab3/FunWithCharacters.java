import java.util.Scanner;

public class FunWithCharacters {
   /* Type your code here */
   public String checkCharacter(String word, int index)
   {
      char ch = word.charAt(index);
      if (Character.isLetter(ch)) 
      {
         return "Character '" + ch + "' is a letter";
      } 
      else if (Character.isDigit(ch)) 
      {
         return "Character '" + ch + "' is a digit";
      } 
      else if (Character.isWhitespace(ch)) 
      {
         return "Character '" + ch + "' is a white space";
      } 
      else 
      {
         return "Character '" + ch + "' is unknown";
      }
   }

   public static void main(String[] args) {
      
      FunWithCharacters labObject = new FunWithCharacters();
      String word = "happy birthday"; // Set string
      int index = 2; // Set specified index to 2
      System.out.println(labObject.checkCharacter(word, index));
      
      index = 5; // Set specified index to 5
      System.out.println(labObject.checkCharacter(word, index));
      
      word = "happy birthday 2 you"; 
      index = 15; // Set specified index to 15
      System.out.println(labObject.checkCharacter(word, index));
      
      word = "happy birthday!"; 
      index = 14; // Set specified index to 14
      System.out.println(labObject.checkCharacter(word, index));
   }
}
