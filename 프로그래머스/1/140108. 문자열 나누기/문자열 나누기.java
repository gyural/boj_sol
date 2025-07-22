class Solution {
    public int solution(String s) {
        int answer = 1;
        
        
        char startChar = s.charAt(0);
        int startCharCount = 1;
        int nonStartCharCount = 0;
        
        for (int i=1; i<s.length()-1; i++){
            char curChar = s.charAt(i);
            
            // 1-1. start랑 같을 때
            if (startChar == curChar){
                startCharCount++;
            }
            // 1-2. start랑 다를 때
            else{ 
                nonStartCharCount++;
            }
            
            // 2 같아질 때 Answer카운트 조건
            if (startCharCount > 0 && startCharCount == nonStartCharCount){
                answer +=1;

                startCharCount = 0;
                nonStartCharCount = 0;
                startChar = s.charAt(i+1);
            }
            
        }
        return answer;
    }
}