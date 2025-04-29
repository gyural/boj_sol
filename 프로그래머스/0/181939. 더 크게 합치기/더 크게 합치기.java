class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String left = "" + a + b;
        String right = "" + b + a;
        
        int leftInt = Integer.parseInt(left);
        int rightInt = Integer.parseInt(right);
        
        return leftInt > rightInt ? leftInt: rightInt;
    }
}