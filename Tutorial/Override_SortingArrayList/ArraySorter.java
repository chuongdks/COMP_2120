import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ArraySorter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int NUM_ELEMENTS = 4;
      ArrayList<Integer> userElements = new ArrayList<Integer>();
      int i;

      for (i = 0; i < NUM_ELEMENTS; ++i) {
         userElements.add(scnr.nextInt());
      }

      Collections.sort(userElements);

      for (i = 0; i < NUM_ELEMENTS; ++i) {
         System.out.println(userElements.get(i));
      }
   }
}