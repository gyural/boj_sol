import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr= s.split(" ");
        int[] arrInt = new int[arr.length];
        
        for (int i=0; i<arr.length; i++) arrInt[i] = Integer.parseInt(arr[i]);
        
        int maxV = arrInt[0];
        int minV = arrInt[0];
        
        for (int v: arrInt) {
            maxV = Math.max(maxV, v);
            minV = Math.min(minV, v);
        }
        
        return minV + " " + maxV;
    }
}