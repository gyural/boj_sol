import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][4];
        
        for (int j=0; j<4; j++) dp[0][j] = land[0][j];
        
        // DP 테이블 쌓기
        for (int i=1; i<land.length; i++){
            for (int j=0; j<4; j++){
                for (int k=0; k<4; k++){
                    if (j!=k){
                        dp[i][j] = Math.max(dp[i][j],land[i][j]+dp[i-1][k]);
                    }
                }
            }
        }
        
        for (int j=0; j<4; j++){
            answer = Math.max(answer, dp[land.length-1][j]);
        }
        
        
        return answer;
    }
}