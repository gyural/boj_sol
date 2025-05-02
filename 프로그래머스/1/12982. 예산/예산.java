import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int v: d) heap.add(v);
        
        while (heap.size() > 0) {
            budget -= heap.poll();
            if (budget>=0) answer++;
            else break;
        }
        return answer;
    }
}