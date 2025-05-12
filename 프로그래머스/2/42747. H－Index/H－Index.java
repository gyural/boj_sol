import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        int maxCitation = 10000;
        int[] idxMorethen = new int[maxCitation+1];
        for (int i=0; i <=maxCitation; i++){
            idxMorethen[i] = size;
        }
        
        for (int v: citations) {
            for (int i=v+1; i<=maxCitation; i++) idxMorethen[i]--;
        }
        
        
        for (int i=1; i<=maxCitation; i++){
            if (i <= idxMorethen[i]) answer = i;
            else break;
        }
        
        return answer;
    }
    
    // [6, 5, 3, 1, 0]
}