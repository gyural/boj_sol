import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> stack = new ArrayDeque();

        for(int i=0; i<s.length(); i++){
            char targetChar = s.charAt(i);
            
            if (stack.size() <= 0){
                stack.addFirst(targetChar);
            } else{
                char peek = stack.peek();
                
                if (peek == '(' && targetChar == ')') stack.pollFirst();
                else stack.addFirst(targetChar);
            }
        }
        
        return stack.size() > 0? false : true;
    }
}