import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxCost = -1;
        
        // 1. 간선 정보 저장
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        
        for (int i=0; i<edge.length; i++){
            int a = Integer.valueOf(edge[i][0]);
            int b = Integer.valueOf(edge[i][1]);
            
            if (edgeMap.get(a) == null){
                List<Integer> firstArr = new ArrayList<>();
                firstArr.add(b);
                edgeMap.put(a, firstArr);
            } else {
                edgeMap.get(a).add(b);
            }
            
            if (edgeMap.get(b) == null){
                List<Integer> firstArr = new ArrayList<>();
                firstArr.add(a);
                edgeMap.put(b, firstArr);
            } else {
                edgeMap.get(b).add(a);
                
            }
        }
        
        
        Set<Integer> visit = new HashSet<>();
        Deque<QEl> Q = new ArrayDeque<>();
        Q.addLast(new QEl(1, 0));
        visit.add(1);
        
        while (Q.size() > 0) {
            QEl curEl = Q.pollFirst();
            int curV = curEl.v;
            int curCost = curEl.cost;
            // System.out.println("QEL(v= " + curV + ", cost=" + curCost + ")" );
            
            if (curCost > maxCost) {
                answer = 1;
                maxCost = curCost;
            }
            else if (curCost == maxCost) {
                answer++;
            }
            
            // 탐색 시작
            if (edgeMap.get(curV) == null){
                    continue;
            }
            
            List<Integer> nxtVArr = edgeMap.get(curV);
            for (Integer nxtV : nxtVArr){
                if (visit.contains(nxtV) == false){
                    visit.add(nxtV);
                    Q.addLast(new QEl(nxtV, curCost+1));
                }
            }
            
            
        }
        
        
        return answer;
    }
    
    
    public class QEl {
        int v;
        int cost;
        
        public QEl(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}