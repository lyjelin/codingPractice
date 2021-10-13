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
            
            List<List<Integer>> set = new ArrayList<List<Integer>>();
            
            int prev = list.get(0); int cur=-1;
            int count = 1;
            
            for (int i=1;i<list.size();i++){
                cur = list.get(i);
                if (prev == cur){
                    count++;
                }
                else {
                    List<Integer> temp = new ArrayList<Integer>();
    
                    temp.add(prev);
                    temp.add(count);
                    set.add(temp);
                    count=1;
                }
                prev=cur;
            }
            if (cur!=0) {
              List<Integer> temp = new ArrayList<Integer>();
    
                    temp.add(cur);
                    temp.add(count);
                    set.add(temp);
            }
    
      String ans="NO";
    
      if(set.size()<2) ans = "YES";
      else if (set.size()==2){
          if (set.get(1).get(0)==1 && set.get(1).get(1)==1) ans="YES";
          else if (set.get(0).get(0)-set.get(1).get(0)==1){
              if (set.get(0).get(1)==1) ans="YES";
          }
      }
      else ans="NO";
    
           
            return ans;
            
            
        }
}
