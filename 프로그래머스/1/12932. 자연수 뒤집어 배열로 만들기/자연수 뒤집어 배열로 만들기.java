import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        
        
        
        int[] intString = Arrays.stream(Long.toString(n).split("")).mapToInt(Integer::parseInt).toArray();
        int size = intString.length;
        int[] answer = new int[size];
        System.out.println(Arrays.toString(intString));
        for (int i = size-1; i >=0; i--){
            answer[size-1-i] = intString[i];
        }
        return answer;
    }
}