public class FindAns {
    public String solution(int[] answers) {
        int[] answer = {};
        
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int a1=0; int a2=0; int a3=0;
        
        for (int i=0;i<answers.length;i++){
            if (answers[i] == p1[i%5]) a1++;
            if (answers[i] == p2[i%8]) a2++;
            if (answers[i] == p3[i%10]) a3++;
        }

        List<Integer> temp = new ArrayList<Integer>();
        
        temp.add(a1); temp.add(a2); temp.add(a3);

        int max = 0;
        for (int i=0;i<3;i++){
            if (temp.get(i)>max){
                max = temp.get(i);
            }
        }
        int maxCnt=0;
        for (int i=0;i<3;i++){
            if (temp.get(i)==max) maxCnt++;
        }
        answer = new int[maxCnt];
        int idx = 0;
        for (int i=0;i<3;i++){
            if (temp.get(i)==max) answer[idx++] = i+1;
        }
        
        return answer;
    }
}
