class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxL = -1;
        int minL = -1;
        
        for (int[] card : sizes) {
            int a = card[0];
            int b = card[1];
            
            int curMax = Math.max(a,b);
            int curMin = Math.min(a,b);
            
            maxL = Math.max(curMax, maxL);
            minL = Math.max(curMin, minL);
            
        }
        
        return maxL * minL;
    }
}