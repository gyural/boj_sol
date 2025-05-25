import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        PriorityQueue<List<Integer>> heap = new PriorityQueue<List<Integer>> ((a,b) -> a.size() - b.size());
        
        int start = 0;
        int end = 0;
        for (int i = 1; i<s.length()-1; i++){
            if (s.charAt(i) == '{'){
                start = i;
            } else if (s.charAt(i) == '}'){
                end = i;
                String[] tmp =  s.substring(start+1, end).split(",");
                
                List<Integer> tmp2 = new ArrayList<Integer>();
                for (String str : tmp) tmp2.add(Integer.parseInt(str));
                
                heap.add(tmp2);
            }
        }
        
        int[] answer = new int[heap.size()];
        int count = 0;
        
        Set<Integer> hashSet = new HashSet<Integer>();
        while(heap.size() >0){
            List<Integer> tmp3 = heap.poll();
            
            for (int i =0; i<tmp3.size(); i++){
                int v = tmp3.get(i);
                if (hashSet.contains(v) == false) {
                    answer[count++] = v;
                    hashSet.add(v);
                }
            }
        }
        
        return answer;
    }
}