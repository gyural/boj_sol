import java.util.*;

// 12시 49분 시작
// 1시 38분 완료 0.9솔
class Solution {
    Set<Set<String>> answerSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        int userSize = user_id.length;
        int bannedSize = banned_id.length;
        List<List<String>> possibleArr = new ArrayList<>();
        
            
        for (int i=0; i<bannedSize; i++){
            List<String> curList = new ArrayList<>();
            String bannedTarget = banned_id[i];

            for (int j=0; j<userSize; j++){
                String userTarget = user_id[j];

                if (isPossible(bannedTarget, userTarget)){
                    curList.add(userTarget);
                }
            }
            possibleArr.add(curList);
        }

        Set<String> curSet = new HashSet<>(); 
        DFS(0, bannedSize-1, curSet, possibleArr);
        return answerSet.size();
    }
    
     public void DFS(int curIdx, int endIdx, Set<String> curSet, List<List<String>> possibleArr){
        if (curIdx > endIdx){
            if (!answerSet.contains(curSet)){
                answerSet.add(new HashSet<>(curSet));
            }
            
            
        }
        else{
            for (String s : possibleArr.get(curIdx)){
                if (!curSet.contains(s)){
                    curSet.add(s);
                    DFS(curIdx+1, endIdx, curSet , possibleArr);
                    curSet.remove(s);
                }
            }
        }
    }
    
    private boolean isPossible(String masked, String target){
        if (masked.length() != target.length()){
            return false;
        }
        int size = masked.length();
        
        for (int i=0; i<size; i++){
            char maskedChar  = masked.charAt(i);
            char targetChar  = target.charAt(i);
            
            if (maskedChar == '*'){
                continue;
            }
            
            if (maskedChar != targetChar){
                return false;
            }
        }
    
        
        return true;
    }
    
}