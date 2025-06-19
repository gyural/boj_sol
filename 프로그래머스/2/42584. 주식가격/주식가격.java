import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        
        int[] answer = new int[size];
        
        PriorityQueue<El> heap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.val, a.val));
       
        for (int i=0; i<size; i++){
            while(heap.size() >0 && heap.peek().val > prices[i]){
                El top = heap.poll();
                answer[top.idx] = i-top.idx;
            }
            
            heap.add(new El(i, prices[i]));
        }
        
        // 떨어진적 없는 것들 채우기
        while(heap.size() >0){
            El top = heap.poll();
            answer[top.idx] = size-1 - top.idx;
        }
        
        return answer;
    }
    
    public class El {
        Integer idx;
        Integer val;
        
        public El(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}