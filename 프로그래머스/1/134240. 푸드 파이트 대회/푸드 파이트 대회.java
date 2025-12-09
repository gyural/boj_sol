import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        String left = "";
        int size = food.length;
        
        for (int i=1; i<size; i++){
            int possibleNum = food[i] / 2;
            
            for (int j=0; j< possibleNum; j++) {
                left += "" + i;
                answer += "" + i;
                
            }
        }
            
    
        int leftSize = left.length();
        answer += "0";
        for (int i=leftSize-1; i>=0 ;i--){
            answer += left.charAt(i);
        }
        
        
        return answer;
    }
}