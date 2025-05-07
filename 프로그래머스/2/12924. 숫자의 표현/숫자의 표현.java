import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) arr[i] = i;
        
        int pt1 = 1;
        int pt2 = 1;
        
        while (pt1 <= n && pt2 <= n){
            int sum =0;
            for (int i=pt1; i<=pt2; i++){
                sum += arr[i];
            }
            
            if (sum == n){
                answer +=1;
            }
            
            if(sum < n){
                pt2 +=1;
            } else{
                pt1 +=1;
            } 
        }
        return answer;
    }
}