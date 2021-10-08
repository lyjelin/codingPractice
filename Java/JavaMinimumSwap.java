public class JavaMinimumSwap {
    static int minimumSwaps(int[] arr) {
        
        int temp;
        int count = 0;
        
        for (int i=0;i<arr.length-1;i++){
            if (arr[i] != i+1){
                for (int j=i+1;j<arr.length;j++){
                    if (i+1 == arr[j]){
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        count++;
                    }
                    
                }
            }
        }
        return count;
    } 
}
