class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int targetLen = p.length();
        Long pLong = Long.parseLong(p);
        
        for (int i =0; i+targetLen-1 < t.length(); i++){
            String subStr = t.substring(i, i+targetLen);
            
            answer = Long.parseLong(subStr) <= pLong? answer+1: answer;
        }
        return answer;
    }
}