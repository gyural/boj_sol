import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> clotheMap = new HashMap<String, List<String>>();
        
        for (String[] cloth: clothes) {
            if (clotheMap.get(cloth[1]) != null){
                clotheMap.get(cloth[1]).add(cloth[0]);
            } else{
                clotheMap.put(cloth[1], new ArrayList<String>());
                clotheMap.get(cloth[1]).add("NONE");
                clotheMap.get(cloth[1]).add(cloth[0]);
            }
        }
        
        for (String part : clotheMap.keySet()){
                answer *= clotheMap.get(part).size();
            }
        
        return answer-1;
    }
}