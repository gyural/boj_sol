import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
       
        // 0을 포함할 때
        for(String v : Integer.toString(n,k).split("0")){
            if (!v.equals("")){
                boolean isPrime = true;
                long targetValue = Long.valueOf(v);
                
                for (long i=2; i<=(long) Math.sqrt(targetValue); i++){
                    if (targetValue % i == 0){
                        isPrime = false;
                        break;
                    }
                }
                
                if (targetValue>=2 && isPrime) answer ++;
            }
        }
        
        return answer;
    }
}