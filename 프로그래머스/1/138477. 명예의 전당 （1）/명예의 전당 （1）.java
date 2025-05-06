import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int size = score.length;
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        for (int i=0; i<size; i++){
            int s = score[i]; 
            heap.add(s);
            
            if (heap.size() > k) heap.poll();
            
            answer[i] = heap.poll();
            heap.add(answer[i]);
        }
        
        return answer;
    }
}