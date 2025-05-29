import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)-> b-a);
        
        
        for (int s: score){
            heap.add(s);
        }
        
        while(heap.size()>=m){
            int lastValue = 0;
            for (int i=0; i<m; i++){
                lastValue = heap.poll();
            }
            
            answer += lastValue * m;
        }
        
        return answer;
        
        
    }
}