import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String longString = ""+n;
        
        String[] longArray = longString.split("");
        
        Arrays.sort(longArray, Collections.reverseOrder());
        
        String answerString = "";
        
        for (String v: longArray){
            answerString += v;
        }
        System.out.println(answerString);
        
        return Long.parseLong(answerString);
    }
}