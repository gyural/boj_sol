import java.util.Deque;
import java.util.ArrayDeque;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque();
        
        for (int i=0; i< s.length(); i++){
            char targetChar = s.charAt(i);
            if (stack.peek() != null){
                
                char peek = stack.peek();
                if (peek == targetChar) {
                    stack.pollFirst();
                }
                else {
                    stack.addFirst(targetChar);
                }
                
            } else{
                stack.addFirst(targetChar);
            }
            
            
        }
        
        return stack.size() > 0? 0:1;
    }
}