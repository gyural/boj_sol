import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> heap = new PriorityQueue<>((a,b) -> Long.compare(a,b));
        
        
        for (int v: scoville) heap.add(new Long(v));
        
        
        while(heap.size() > 0){
            // 종료 1 : 가장 순한 녀석이 K이상 일때 종료
            if (heap.peek() >= K){
                break;
            }
            // 종료 2 : 음식이 한가지가 되었을 때 K 미만일 때
            if (heap.size() == 1){
                if (heap.peek() < K){
                    answer = -1;
                }
                break;
            }
            
            long m1 = heap.poll();
            long m2 = heap.poll();
            
            heap.add(getNewFood(m1, m2));
            answer++;
        }
        
        
        return answer;
    }
    
    // f1 : 가장 순한맛 , f2: 두번째로 순한 맛
    private long getNewFood(long f1, long f2){
        return f1 + (f2 * 2);
    }
}