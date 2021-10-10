import java.util.*;


public class JavaBubbleSort {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
    // Write your code here
        int count = 0;
        int a1;
        int a2;
        for (int i=0;i<a.size();i++){
            for (int j = 0; j< a.size()-1;j++){
                a1 = a.get(j);
                a2 = a.get(j+1);
                if (a1>a2){
                    a.set(j, a2);
                    a.set(j+1, a1);
                    count++;
                }
            }
            
        }
        
        System.out.println("Array is sorted in "+count+" swaps.");
        System.out.println("First Element: "+a.get(0));
        System.out.println("Last Element: "+a.get(a.size()-1));
        
    }

}

