// Measurable Interface
import java.util.ArrayList;

public interface Measureable{
    int getMeasure();

    public static double Average (ArrayList<Measureable> a)
    {
        // for (int i = 0; i < a.size(); i++)
        // {
        // }
        double sum = 0;
        for (Measureable m : a)
        {
            sum += m.getMeasure();
        }
        return sum/a.size();
    }

}



// // Country file
// public class Country implements Measureable{
//     private int population;
//     @Override
//     public int getMeasure()
//     {
//         return population;
//     }
// }