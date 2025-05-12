class Solution {
    public int[] solution(int n, long left, long right) {
        long size = right-left;
        int[] answer = new int[(int)size+1];
        
        for (long i =left; i<=right; i++){
            long row = i / n + 1;
            long column = i % n + 1;
            long idx = i-left;
            answer[(int)idx] = Math.max((int)row, (int)column);
            
        }
        
        return answer;
    }
}