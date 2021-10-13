import java.util.*;

public class JavaSherlokAndValidString {
    public static String isValid(String s) {
        // Write your code here
            List<Integer> list = new ArrayList<Integer>();
            
            for (int i=0;i<27;i++)
                list.add(0);
                
            for (int i=0;i<s.length();i++){
                int idx = s.charAt(i)-'a';
                int cnt = list.get(idx)+1;
                list.set(idx, cnt);
            }
            
            Collections.sort(list, Collections.reverseOrder());
            
            List<Integer> set = new ArrayList<Integer>();
            int i=0;
            while(list.get(i)>0){
                set.add(list.get(i));
                i++;
            }
              int prev = set.get(0);
      int cur; 
      int c1=1;
      boolean flag = true;
    
      for (int j=0;j<set.size();j++){
        cur = set.get(j);
        if (prev!=cur){
          c1++;
          if (prev-cur>1) {
            flag = false;
            break;
          }
        }
        prev = cur;
      }
    
     
            String ans;
            if (c1<2){
              if (flag == true) ans = "YES";
              else ans ="NO";
            } else ans="NO";        
            return ans;
            
            
        }
}
