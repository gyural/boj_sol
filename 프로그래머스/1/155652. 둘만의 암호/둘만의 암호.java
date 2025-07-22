class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i=0; i<s.length(); i++){
            char targetChar = s.charAt(i);
            
            int cnt = 0;
            while(cnt < index){
                targetChar  = (char)((int)targetChar + 1);
                targetChar = (int)targetChar > (int)'z'? (char)((int)targetChar-(int)'z'+(int)'a'-1) : targetChar;
                
                if (!skip.contains(("" + targetChar))){
                    cnt++;
                }
            }
            
            answer += targetChar;
        }
        
        return answer;
    }
}