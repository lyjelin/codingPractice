import java.util.*;

public class JavaStringMakeAnagram {
    public static int makeAnagram(String a, String b) {
        // Write your code here
            List<Integer> aa = new ArrayList<Integer>();
            List<Integer> bb = new ArrayList<Integer>();
            
            for (int i=0;i<27;i++){
                aa.add(0);
                bb.add(0);
            }
        
            for (int i=0;i<a.length();i++){
                int idx = a.charAt(i) - 'a';
                int cnt = aa.get(idx) + 1;
                aa.set(idx, cnt);
            }
            for (int i=0;i<b.length();i++){
                int idx = b.charAt(i) - 'a';
                int cnt = bb.get(idx) + 1;
                bb.set(idx, cnt);
            }
            
            int ans =0;
            for (int i=0;i<aa.size();i++) {
                int diff = Math.abs(aa.get(i)-bb.get(i));
                ans+=diff;
            }
            
            return ans;
        
        }
    
}
