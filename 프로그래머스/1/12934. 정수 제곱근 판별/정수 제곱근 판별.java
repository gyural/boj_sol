class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long targetLong = (int) Math.sqrt(n);
        
        return targetLong * targetLong == n ? (targetLong+1)*(targetLong+1) : -1;
    }
}