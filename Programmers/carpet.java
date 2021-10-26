public class carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i=yellow;i>0;i--){
            if (yellow%i == 0){
                int w = i; int h = yellow/i;
                int blen = w*2+h*2+4;
                if (brown == blen){
                    answer[0] = w+2;
                    answer[1] = h+2;
                    break;
                }
            }
        }
        
        return answer;
    }
}
