public class ReturnMethodOutput {
   public int changeValue(int x) {
      return x + 3;
   }

   public static void main (String [] args) {
      ReturnMethodOutput output = new ReturnMethodOutput();
      System.out.print(output.changeValue(2));
   }
}