
import java.util.*;


public class JavaArrayLeftRotation {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    
        int alen = a.size();
    
        List<Integer> tempa = new ArrayList<Integer>();
    
        for (int i=d;i<alen;i++){
            tempa.add(a.get(i));
        }
    
        for (int i=0;i<d;i++){
            tempa.add(a.get(i));
        }
        
        return tempa;
    }

}
