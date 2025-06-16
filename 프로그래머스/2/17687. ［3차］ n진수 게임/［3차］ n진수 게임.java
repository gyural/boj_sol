class Solution {
    static char[] els = new char[]{'0', '1', '2', '3', '4','5','6','7','8','9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String fullString = "0";
        for (int i=1; i<=m*t; i++){
            fullString += getNumber(n, i);
        }
        
        for (int i=0; i<fullString.length(); i++){
            if (i % m == p-1) answer += fullString.charAt(i);
            if (answer.length() == t) break;
        }
        
        return answer;
    }
    
    // n : 진법 v : 10진수 Value
    private String getNumber(int n, int value) {
        String result = "";
        
        // size : 자리수
        int size = 1;
        while (true) {
            // size 자리수로 표현할 수 있는 최대값
            int maxBySize = 0;
            for (int i=1; i<=size; i++){
                maxBySize += (int) Math.pow(n, i-1) * (n-1);
            }
            
            if (maxBySize >= value){
                break;
            } else {
                size +=1;
            }
        }
        
        
        for (int i= size-1; i>=0; i--){
            result += els[value / (int) Math.pow(n, i)];
            value = value % (int) Math.pow(n, i);
        }
        
        return result;
    }
}
