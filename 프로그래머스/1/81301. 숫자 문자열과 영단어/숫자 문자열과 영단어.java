import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int solution(String s) {
        String answer = "";
        
        Map<String,Character> engToNum = new HashMap();
        engToNum.put("zero",'0');
        engToNum.put("one",'1');
        engToNum.put("two",'2');
        engToNum.put("three",'3');
        engToNum.put("four",'4');
        engToNum.put("five",'5');
        engToNum.put("six",'6');
        engToNum.put("seven",'7');
        engToNum.put("eight",'8');
        engToNum.put("nine",'9');
        
        String temp = "";
        
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c >= '0' &&  c <= '9') {
                answer += c;
            }
            else {
                temp += c;
                if (engToNum.get(temp) != null){
                    answer += engToNum.get(temp);
                    temp = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}