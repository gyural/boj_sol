import java.util.*;

// 12시 5분 시작
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int minSize = 100001;
        
        Set<String> gemSet = new HashSet<>();
        for (String gem: gems){
            gemSet.add(gem);
        }
        int getNum = gemSet.size();
        
        Map<String, Integer> gemCountMap = new HashMap<>();
        for (String gem : gemSet){
            gemCountMap.put(gem, 0);
        }
        
        
        int startIdx = 0;
        int endIdx = 0;
        int curCount=0;
        for (int i=0; i<gems.length; i++){
            
            String endGem = gems[i];
            gemCountMap.put(endGem, gemCountMap.get(endGem)+1);
            curCount = gemCountMap.get(endGem) == 1? curCount+1 : curCount;
            endIdx = i;
                
            // startIdx 줄이기
            while(isStartIndexValid(gemCountMap, gems[startIdx])){
                String startGem = gems[startIdx];
                gemCountMap.put(startGem, gemCountMap.get(startGem)-1);
                startIdx++;
                
            }
            
            if (curCount == getNum){
                if (minSize > (endIdx-startIdx)){
                    minSize = endIdx-startIdx;
                    answer[0] = startIdx;
                    answer[1] = endIdx;
                }
            }
        }
        
        answer[0]++;
        answer[1]++;
        return answer;
    }
    
    public boolean isStartIndexValid(Map<String, Integer> gemCountMap, String gem){
        if (gemCountMap.get(gem) > 1){
            return true;
        }
        
        return false;
        
    }
}