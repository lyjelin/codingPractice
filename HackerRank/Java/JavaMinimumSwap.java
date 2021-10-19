public class JavaMinimumSwap {
    static int minimumSwaps(int[] arr) {
        int count = 0;
        int temp = 0;
        
        for (int i=0;i<arr.length-1;i++){
            if (arr[i] != i+1){
                for (int j=i+1;j<arr.length;j++){
                    if (arr[j] == i+1) {
                        temp = j;
                        break;
                    }
                }
                arr[temp] = arr[i];
                arr[i] = i+1;
                count++;
                
            }
        }
        return count;
    }
}
