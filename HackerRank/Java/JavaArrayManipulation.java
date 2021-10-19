import java.util.*;

public class JavaArrayManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        
        long[] max = new long[n+1];
        for (int i=0;i<n+1;i++){
            max[i] = 0;
        }
    
        for (int i=0;i<queries.size();i++){
            int start = queries.get(i).get(0);
            int end = queries.get(i).get(1);
            
            max[start] += queries.get(i).get(2);
            if (n>=end+1)
                max[end+1] -= queries.get(i).get(2);
        }
        
        long ans = 0;
        long x = max[0];
        for (int i=1;i<n+1;i++){
            x += max[i];
            if (ans<x) ans = x;
        }   
        return ans;
    }

}
