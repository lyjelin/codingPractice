import java.util.*;

public class JavaGreedyMaxMin {
    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
            Collections.sort(arr);
            
            int unfairness = Integer.MAX_VALUE;
            
            for (int i=0;i<arr.size()-k;i++){
                int min = arr.get(i);
                int max = arr.get(i+k-1);
                int x = max - min;
                if (unfairness>x && x>=0) unfairness = x;
            }
            return unfairness;
        }
}
