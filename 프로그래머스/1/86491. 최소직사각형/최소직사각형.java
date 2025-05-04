class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxOfMax = -1;
        int maxOfMin = -1;
        
        for (int[] card: sizes){
            int maxLen = card[1] > card[0]? card[1] : card[0];
            int minLen = card[1] < card[0]? card[1] : card[0];
            
            maxOfMax = maxLen > maxOfMax? maxLen : maxOfMax;
            maxOfMin = minLen > maxOfMin? minLen : maxOfMin;
                
        }
        return maxOfMax*maxOfMin;
    }
}