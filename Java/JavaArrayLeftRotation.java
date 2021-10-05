
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

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
