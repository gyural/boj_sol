import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) answer[i] ="";
        
        for (int i=0; i<n; i++){
            int target1Int = arr1[i];
            int target2Int = arr2[i];
            
            
            for (int j=n-1; j>=0; j--){
                int targetValue = (int)Math.pow(2,j); // 현재 자리수 이진값
                boolean flag = false;
                if (target1Int >= targetValue) {
                    target1Int %= targetValue;
                    flag = true;
                }
                if (target2Int >= targetValue) {
                    target2Int %= targetValue;
                    flag = true;
                }
                
                answer[i] += flag==true? "#" : " ";
            }
                
        }
        return answer;
    }
}