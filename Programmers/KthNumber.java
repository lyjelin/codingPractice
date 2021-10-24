public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i=0;i<commands.length;i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int idx = commands[i][2]-1;
            int[] temp = new int[end-start];
            int cnt = 0;
            for (int j=start;j<end;j++) {
                temp[cnt++] = array[j];
            }
            Arrays.sort(temp);
            answer[i] = temp[idx];
        }
        
    
        return answer;
    }
}
