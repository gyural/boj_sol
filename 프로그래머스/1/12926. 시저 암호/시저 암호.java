class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        int a2zLen = 'z'-'a'+1;
        for (int i=0; i<s.length(); i++){
            char targetChar = s.charAt(i);
            if (targetChar == ' ') {
                answer += ' ';
            }else if (targetChar >= 'A' && targetChar <= 'Z') {
                int shiftChar = (s.charAt(i) + n);
                shiftChar = shiftChar > 'Z'? shiftChar %('Z') + 'A'-1 : shiftChar;
                answer += (char)shiftChar;
                
            } else if (targetChar >= 'a' && targetChar <= 'z'){
                int shiftChar = (s.charAt(i) + n);
                shiftChar = shiftChar > 'z'? shiftChar %('z') + 'a'-1 : shiftChar;
                answer += (char)shiftChar;
            }
        }
        return answer;
    }
}