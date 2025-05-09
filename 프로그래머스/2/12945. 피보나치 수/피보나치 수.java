import java.util.Arrays;

class Solution {
    static int[] fibo = new int[1000001];
    // static int[] fibo = new int[1000001];
    // static int[] fibo = new int[10];
    
    public int solution(int n) {
        
        fibo[0] = 0;
        fibo[1] = 1;
        
        for (int i=2; i<=n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
            fibo[i] %= 1234567;
        }
            
        return fibo[n];
    }
}