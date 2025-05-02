import java.util.Arrays;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        int[] dp = new int[1001];
        for (int i = 1; i <= 1000; i++){
            for (int j = i; j <= 1000; j+=i){
                dp[j]++;
            }
        }
        
        for (int i = left; i<=right; i++){
            if (dp[i] % 2 == 0){
                answer += i;
            } else{
                answer -= i;
            }
        }
        
        return answer;
    }
}