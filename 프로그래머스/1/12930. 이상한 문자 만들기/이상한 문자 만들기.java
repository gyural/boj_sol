import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        int diff = 'a' - 'A';
        String[] words = s.split(" ", -1); // 공백 유지
        
        for (int j=0; j<words.length; j++ ){
            String word = words[j];
            
            if (j != 0) answer += ' ';
            
            for (int i=0; i<word.length(); i++){
                char targetChar = word.charAt(i);
                // 1. 짝수일 때
                if (i % 2 == 0) {
                    if (targetChar >= 'a' && targetChar <= 'z') targetChar -= diff;
                }
                // 2. 홀수일 때
                else {
                    if (targetChar >= 'A' && targetChar <= 'Z') targetChar += diff;
                }
                
                answer += targetChar; 
                
            }
            
        }
        
        
        return answer;
    }
}