class Solution {
    public long solution(int a, int b) {
        
        int max = a > b? a: b;
        int min = a < b? a: b;
        
        long answer = min;
        
        for (int i = min+1; i<=max; i++){
            answer += i;
        }
        return answer;
    }
}