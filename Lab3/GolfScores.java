import java.util.Scanner;

public class GolfScores {
    public String golfScore (int par, int strokes)
    {
        if (par < 3 || par > 5)
        {
            return "Error";
        }

        int difference = strokes - par;

        switch (difference) 
        {
            case -2:
                return "Eagle";
            case -1:
                return "Birdie";
            case 0:
                return "Par";
            case 1:
                return "Bogey";
            default:
                return "Error";
        }
    }
    
    public static void main(String[] args) {
        GolfScores score = new GolfScores();
        Scanner scnr = new Scanner(System.in);
        int par;
        int strokes;
        String name;

        par = scnr.nextInt();
        strokes = scnr.nextInt();

        name = score.golfScore(par, strokes);

        System.out.println(name);
    }
}
