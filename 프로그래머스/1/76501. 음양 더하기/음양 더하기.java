class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i =0; i < absolutes.length; i++){
            int targetValue = absolutes[i];
            answer = signs[i]? answer+targetValue : answer-targetValue;
        }
        return answer;
    }
}