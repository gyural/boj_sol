class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        
        for (int v : arr){
            sum += v;
        }
            
        return 1.0 * sum / arr.length;
    }
}