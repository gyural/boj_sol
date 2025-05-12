import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack= new ArrayDeque<Character>();
        int answer = 0;
        int size = s.length();
        for (int i =0; i< size; i++) s += s.charAt(i);
        
        for (int i=0; i< size; i++){
            for (int j=i; j < i+size; j++){
                char peek = stack.peek() == null? 'F' : stack.peek();
                char target = s.charAt(j);
                if (peek != 'F'){
                    if (peek == '[' && target == ']') {
                        stack.removeFirst();
                    }
                    else if (peek == '{' && target == '}') {
                        stack.removeFirst();
                    }
                    else if (peek == '(' && target == ')') {
                        stack.removeFirst();
                    }
                    else{
                        stack.addFirst(target);
                    }
                } else{
                    stack.addFirst(target);
                }
            }
            if (stack.peek() == null) answer +=1;
            
            while (stack.peek() != null) stack.removeFirst();
        }
        
        return answer;
    }
}