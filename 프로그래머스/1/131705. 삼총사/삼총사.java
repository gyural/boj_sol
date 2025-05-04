import java.util.List;
import java.util.ArrayList;

class Solution {
    static int answer = 0;
    
    public int solution(int[] number) {
        List<Integer> BrosList = new ArrayList();
        for (int v: number) BrosList.add(v);
        
        for (int i=0; i<number.length; i++) DFS(number[i], BrosList.subList(i+1, number.length), 1);
        return answer;
        
    }
    
    static private void DFS(int sum, List<Integer> targets, int curBros){
        // System.out.println(targets.toString());
        if (curBros == 3) {
            if (sum == 0) answer++;
            return;
        }
        
        for (int i =0; i < targets.size(); i++){
            DFS(sum+targets.get(i), targets.subList(i+1, targets.size()), curBros+1);
        }
    }
}