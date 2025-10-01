import java.util.*;

class Solution {
    public int solution(int x, int y, int[][] puddles) {
        int answer = 0;
        int dp[][] = new int[y][x];
        dp[0][0] = 1;
        for (int i=0; i<y; i++){
            for (int j=0; j<x; j++){
                if (i==0 && j==0){
                    continue;
                }
                
                if (isPool(i,j, puddles)) {
                    continue;
                } 
                dp[i][j] = (getUpperTimes(dp, i, j, puddles) 
                            + getLeftTimes(dp, i, j, puddles))%1000000007;
            }
        }
        
       
        
        return dp[y-1][x-1];
    }
    
    private int getUpperTimes(int[][] dp, int y, int x, int[][] puddles){
        int nxtY = y-1;
        int nxtX = x;
        
        if (nxtY < 0){
            return 0;
        }
        
        if (isPool(nxtY, nxtX, puddles)){
            return 0;
        }
        
        return dp[nxtY][nxtX];
            
    }
    
    private int getLeftTimes(int[][] dp, int y, int x, int[][] puddles){
        int nxtY = y;
        int nxtX = x-1;
        
        if (nxtX < 0){
            return 0;
        }
        
        if (isPool(nxtY, nxtX, puddles)){
            return 0;
        }
        
        return dp[nxtY][nxtX];
            
    }
    
    private boolean isPool(int y, int x, int[][] puddles) {
        int size = puddles.length;
        for (int i=0 ; i<size; i++){
            if (puddles[i][0]-1 == x && puddles[i][1]-1 == y){
                return true;
            }
        }
        return false;
    }
}