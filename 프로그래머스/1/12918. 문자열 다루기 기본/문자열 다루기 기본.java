class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if (len == 4 || len == 6){
            answer = true;
        }else{
            return false;
        }
        
        for (int i=0; i<len; i++){
            if (s.charAt(i) < (int)'0' || s.charAt(i) > (int)'9') return false;
        }
        return answer;
    }
}