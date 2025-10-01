import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int baseNum = s / n;
        int leftNum = s % n;
        
        if (baseNum < 1){
            return new int[]{-1};
        }
        
        // 1. baseNum으로 다 채우기
        Arrays.fill(answer,baseNum);
        
        // 2. 뒤에서 부터 나머지 수만큼 채우기
        for (int i=0; i<leftNum; i++){
            answer[(n-1) -i]++;
        }
        
        return answer;
    }
}