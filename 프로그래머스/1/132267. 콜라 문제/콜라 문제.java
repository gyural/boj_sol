class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a){
            // 1. 여분 남기고
            int spare = n % a;
            
            // 2. 새롭게 받기
            int newNum = n / a * b;
            answer += newNum;
            
            n = newNum + spare;
            
        }
        return answer;
    }
}