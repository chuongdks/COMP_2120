import java.util.ArrayList;

public class PlayerManagerSorted {
   private ArrayList<Integer> players;

   // Constructor creates an empty ArrayList of player numbers
   public PlayerManagerSorted() {
      players = new ArrayList<Integer>();
   }

   // Adds playerNum to end of ArrayList
   public void addPlayer(int playerNum) {
      int i = 0;
      boolean foundHigher = false;

      // Look for first item greater than playerNum
      foundHigher = false;
      i = 0;

      while ((!foundHigher) && (i < players.size())) {
         if (players.get(i) > playerNum) 
         {
            players.add (i, playerNum);
            foundHigher = true;
         }

         ++i;
      }

  
      if (!foundHigher) { // No higher number found, add at end
         players.add(playerNum);
      }
   }

   // Prints player numbers currently in ArrayList
   public void printPlayers() {
      int i;

      for (i = 0; i < players.size(); ++i) {
         System.out.println(" " + players.get(i));
      }
   }

   // Uses an object of type PlayerManagerSorted 
   public static void main(String[] args) {
      PlayerManagerSorted teamRoster = new PlayerManagerSorted();
      teamRoster.addPlayer(55);
      teamRoster.addPlayer(4);
      teamRoster.addPlayer(50);
      teamRoster.addPlayer(19);

      teamRoster.printPlayers();
   }
}
