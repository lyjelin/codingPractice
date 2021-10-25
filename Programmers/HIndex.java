import java.util.*;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int max = 0; int h=0;
        
        for (int i=0;i<citations.length;i++){
            int cnt = 0;
            for (int j=0;j<citations.length;j++){
                if (citations[j]>=citations[i]) cnt++;
            }
            if (citations[i] == cnt){
                h = citations[i];
                if (max<h) max = h;
            }
        }
    
        
        answer = max;
        
        return answer;
    }
}
