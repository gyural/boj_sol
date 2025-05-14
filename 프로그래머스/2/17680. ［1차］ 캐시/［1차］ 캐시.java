import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 전처리
        for (int i=0; i< cities.length; i++){
            cities[i] = cities[i].toUpperCase();           
        }    
    
        
        Deque<String> casche = new ArrayDeque();
        
        
        for (int i =0; i<cities.length; i++){
            while (casche.size() > cacheSize){
                casche.pollFirst();
            }
            
            // MISS
            if (casche.size() <= 0) {
                answer += 5;
                casche.addLast(cities[i]);
                continue;
            }
            
            // 탐색
            boolean isHit = false;
            int curSize = casche.size();
            for (int k=0; k<curSize; k++){
                String peek = casche.pollLast();
                
                if (peek.equals(cities[i])){
                    isHit = true;
                } else{
                    casche.addFirst(peek);
                }
            }
            
            answer = isHit == true ? answer+1 : answer+5; 
            
            casche.addLast(cities[i]);
            
            
            
            }
        
        return answer;
    }
}