import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int size = score.length;
        int count = 0;
        int[] answer = new int[size];
        
        Queue<Integer> heap = new PriorityQueue<>(); 
        
        for (int s: score) {
            heap.add(s);
            while (heap.size() > k) {
                heap.poll();
            }
            
            answer[count] = getTopByHeap(heap);
            count++;
        }
        
        
        return answer;
    }
    
    
    private int getTopByHeap(Queue<Integer> heap) {
        int v = heap.poll();
        heap.add(v);
        return v;
    }
}