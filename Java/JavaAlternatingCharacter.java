public class JavaAlternatingCharacter {

    public static int alternatingCharacters(String s) {
        // Write your code here
            char prevCh = s.charAt(0);
            char curCh;
            int count = 0;
            
            for (int i=1;i<s.length();i++){
                curCh = s.charAt(i);
                if (curCh == prevCh) count++;
                else {
                    prevCh = curCh;
                }
                
            }
            
            return count;
        }
    
}
