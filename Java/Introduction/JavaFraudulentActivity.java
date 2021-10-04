package Introduction;
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

public class JavaFraudulentActivity {

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
            int median; int count = 0;
            List<Integer> temp = new ArrayList<Integer>(expenditure.size()+1);
            
            for (int i=0;i<expenditure.size()-1;i++){
                if (i<d) temp.add(expenditure.get(i));
                else if (i >= d){
                    Collections.sort(temp);
                    if (d%2==1){
                        median = temp.get((d-1)/2);
                    }
                    else {
                        median = (temp.get(d/2-1)+temp.get(d/2))/2;
                    }
                    
                    if (median*2<=expenditure.get(i)) count++;
                    temp.set(i%d, expenditure.get(i));
                }
            }
            return count;
    
        }
    
}
