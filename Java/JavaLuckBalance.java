import java.util.*;

public class JavaLuckBalance {
    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
            int important = 0;
            List<Integer> a = new ArrayList<Integer>();
            int ans = 0;
            
            for (int i=0;i<contests.size();i++){
                if ((contests.get(i).get(1) == 1)) {
                    important++;
                    a.add(contests.get(i).get(0));
                }
                ans+=contests.get(i).get(0);
            }
            int temp = 0;
            
            Collections.sort(a);
            
            for (int i=0;i<important - k;i++){
                temp+=a.get(i);
            }
            
            ans -= temp*2;
            return ans;
        }
    
    
}
