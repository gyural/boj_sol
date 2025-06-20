import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i=1; i<=order.length; i++){
            if (answer == order.length) break;
            
            // 1. 메인 벨트 물건 i가 현재 target일 때
            if (i == order[answer]){
                answer++;
                continue;
            }
            
            // 2. stack의 맨위에 target이 나올 때까지 추가
            while(stack.size() > 0 && stack.peek() == order[answer]){
                stack.pollFirst();
                answer++;
                if (answer == order.length) break;
                
            }
            
            stack.addFirst(i);
        }
        
        // 3. stack의 맨위에 target이 나올 때까지 추가
        while(stack.size() > 0 && stack.peek() == order[answer]){
            stack.pollFirst();
            answer++;
            if (answer == order.length) break;
        }
        
        return answer;
    }
}