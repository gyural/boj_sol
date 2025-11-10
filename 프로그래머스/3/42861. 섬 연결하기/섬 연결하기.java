import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] data = new int[n];
        for (int i=0; i<n; i++){
            data[i] = i;
        }
        
        PriorityQueue<El> heap = new PriorityQueue<>((a, b) -> a.cost- b.cost);
        for (int[] cost : costs){
            int curStart = cost[0];
            int curEnd = cost[1];
            int curCost = cost[2];
            El newEl = new El(curStart, curEnd, curCost);
            heap.add(newEl);
        }
        
        while (heap.size() >0){
            //  가장 짧은 Edge 선택
            El curEl = heap.poll();

            int curStart = curEl.start;
            int curEnd = curEl.end;
            int curCost = curEl.cost;
            
            if (find(curStart, data) == find(curEnd, data)){
                continue;
            }
            
            answer += curCost;
            union(curStart, curEnd, data);
            
            
        }
        
        
        return answer;
    }
    
    
    private void union(int a, int b, int[] data) {
        
        int rootA = find(a, data);
        int rootB = find(b, data);
        
        int root = Math.min(rootA, rootB);
        data[rootB] = rootA;
    }
    
    private int find(int a, int[] data) {
        if (data[a] == a){
            return a;
        }
        return data[a] = find(data[a], data);
    }
    
    public class El {
        int start;
        int end;
        int cost;
        
        
        public El(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public String toString() {
            return "El(start = " + start + "end = " + end + "cost = " + cost + ")";
        }
    }
}