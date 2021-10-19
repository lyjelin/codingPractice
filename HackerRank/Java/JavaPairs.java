import java.util.*;

public class JavaPairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
            int count = 0;
            
            Set<Integer> set = new HashSet<Integer>();
            
            for (int i: arr){
                set.add(i);
            }
            for (int i:set){
                if (set.contains(i+k)) count++;
            }
            return count;
        }
}
