import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> good2need = new HashMap<String, Integer>();
        Map<String, Integer> good2count = new HashMap<String, Integer>();
        for (int i=0; i<want.length; i++) {
            good2need.put(want[i], number[i]);
            good2count.put(want[i], 0);
        }
        
        for (int i=0; i <= discount.length-10; i++){
            for (int j=i; j< i+10; j++){
                
                if (good2need.keySet().contains(discount[j])){
                    good2count.put(discount[j], good2count.get(discount[j])+1);
                }
            }
            
            boolean flag = true;
            for (int k=0; k<want.length; k++){
                if (good2count.get(want[k]) != good2need.get(want[k])){
                    flag = false;
                    break;
                }
            }
            
            if (flag == true) answer +=1;
            for (int k=0; k<want.length; k++) good2count.put(want[k], 0);
        }
        
        return answer;
    }
}