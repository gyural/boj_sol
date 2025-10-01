import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Queue<Integer> heapA = new PriorityQueue<>();
        for (int v : A){
            heapA.add(v);
        }
        
        Queue<Integer> heapB = new PriorityQueue<>();
        for (int v : B){
            heapB.add(v);
        }
        
        int target = heapA.poll();
        while(!heapB.isEmpty()){
            int nxtBullet = heapB.poll();
            
            if (nxtBullet > target){
                answer +=1;
                    
                if (heapA.isEmpty()){
                    return answer;
                }
                
                target = heapA.poll();
            }
        
        }
            
        return answer;
    }
}