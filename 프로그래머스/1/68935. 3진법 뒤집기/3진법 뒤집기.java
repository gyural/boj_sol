class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String valueBy3Digit = get3digit(n);
        String valueByReverse = reverseString(valueBy3Digit);
      
        
        return get3digit(valueByReverse);
    }
    
    private int get3digit (String digit3) {
        int result = 0;
        
        int size = digit3.length();
        int count = 0;
    
        for (int i=size-1; i>=0; i--) {
            
            int v = Integer.parseInt(digit3.charAt(i)+"");
            result += Math.pow(3, count) * v;
            count++;
        }
        
        return result;
    }
    
    private String get3digit (int digit10 ) {
        return Integer.toString(digit10, 3);
    }
    
    
    private String reverseString(String target) {
        int size = target.length();
        
        StringBuilder sb = new StringBuilder();
        for (int i=size-1; i>=0; i--) {
            char curChar = target.charAt(i);
            sb.append(curChar);
        
        }
        
        return sb.toString();
    }
}