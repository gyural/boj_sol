import java.util.Set;
import java.util.HashSet;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0; 
        Set<Integer> set= new HashSet<Integer>();
        
        for (int v: numbers){
            set.add(v);
        }
        
        
        for (Integer i = 0; i <= 9; i++){
            if (!set.contains(i)){
                answer += i;
            }
        }
        return answer;
    }
}