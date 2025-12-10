import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        
        int[] answer = new int[size];
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
        
        for (int t =0; t<size; t++){
            int[] c = commands[t];
            int start = c[0]-1;
            int end = c[1]-1;
            int K = c[2];
            
            
            for (int i=start; i<=end; i++){
                heap.add(array[i]);
            }
            
            int curResult=0;
            for (int i=0; i<K; i++){
                curResult = heap.poll();
            }
            heap.clear();
            
            answer[t] = curResult;
        }
        
        return answer;
    }
}