import java.util.*;

class BiggestNumber {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        
        for (int i=0;i<numbers.length;i++){
            nums[i]= String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, new Comparator<String>(){
            public int compare(String n1, String n2){
                return (n2+n1).compareTo(n1+n2);
            }
        });
        
        if (nums[0].equals("0")) return "0";
        
        for (String s : nums){
            answer+=s;
        }
        
        
        return answer;
    }
}
