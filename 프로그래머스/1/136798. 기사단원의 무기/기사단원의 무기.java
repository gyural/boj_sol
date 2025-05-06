import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] dp = new int[number+1];
        for (int i=1; i<= number; i++){
            for (int j=i; j <= number; j+= i) dp[j] +=1;
        }
        
        for (int i=1; i<=number; i++) answer += dp[i] > limit? power : dp[i];
        
        return answer;
    }
}