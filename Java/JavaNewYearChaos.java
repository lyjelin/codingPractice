
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

class JavaNewYearChaos {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
    
        int count = 0;
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;
        
        for (int i=0;i<q.size();++i){
            if (q.get(i) == p1){
                p1=p2;
                p2=p3;
                ++p3;
            }
            else if (q.get(i) == p2){
                count += 1;
                p2 = p3;
                ++p3;
            }
            else if (q.get(i) == p3){
                count += 2;
                ++p3;
            }
            else {
                System.out.println("Too chaotic");
                return;    
            }
        }
        System.out.println(count);
    }

}
