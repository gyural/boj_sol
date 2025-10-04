import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 1;
        long right = (long)n * times[times.length-1];
    
        long mid = 0;
        while (left <= right){
            
            mid = (left + right) / 2;
            
            long completeNum = 0l;
            for (int t : times){
                completeNum += mid / t;
            }
            
            if (completeNum >= n){
                right = mid -1;
            } else{
                left = mid + 1;
            }
            
        }
        
        
        
        return left;
    
    }
}