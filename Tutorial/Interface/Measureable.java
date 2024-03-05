// Measurable Interface
import java.util.ArrayList;

public interface Measureable{
    public int getMeasure();
    public static double average(ArrayList<Measureable> array) {
        double sum = 0;
        for (Measureable m : array)
        {
            sum += m.getMeasure();
        }
        return sum/array.size();
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