class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int centerIdx = (int)len/2;
        
        return len % 2 == 0? s.substring(centerIdx-1, centerIdx+1): s.substring(centerIdx, centerIdx+1);
    }
}

// 길이 5 ->  5/2
// 길이 4 ->  4/2-1 to 4/2
// 길이 1 ->  1/2 = 0
// 길이 2 ->  2/2 = 1