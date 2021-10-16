import java.util.*;

public class JavaStringReverse {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        
        int len = A.length();
        int start = 0;
        int end = len-1;
        int mid = len/2;
        
        boolean flag = true;
        
        while (start<mid){
            if (A.charAt(start)==A.charAt(end)){
                start++;
                end--;
            }
            else {
                flag = false;
            }
        }
        if (flag) System.out.println("Yes");
        else System.out.println("No");
    }
}
