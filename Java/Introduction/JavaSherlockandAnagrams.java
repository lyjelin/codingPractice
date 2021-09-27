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

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
            
            int count = 0;
            
            for (int i=0;i<s.length();i++){
                for (int j=i+1;j<s.length();j++){
                    String str = s.substring(i, j);
                    int len = str.length();
                    String temp = s.substring(i+1);
                    for (int k=0;k<temp.length()-len+1;k++){
                        String temp2 = temp.substring(k, k+len);
                        List<String> ch = new ArrayList<String>(Arrays.asList(temp2.split("")));
                        List<String> strch = new ArrayList<String>(Arrays.asList(str.split("")));
                        Collections.sort(ch);
                        Collections.sort(strch);
                        
                        String t1 = String.join("", strch);
                        String t2 = String.join("", ch);
                        
                        if (t1.compareTo(t2) == 0) count++;
                        
                    }
                }
            }
            return count;
        }
    
    }
    
    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    
            int q = Integer.parseInt(bufferedReader.readLine().trim());
    
            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s = bufferedReader.readLine();
    
                    int result = Result.sherlockAndAnagrams(s);
    
                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
    
            bufferedReader.close();
            bufferedWriter.close();
        }
    }
    