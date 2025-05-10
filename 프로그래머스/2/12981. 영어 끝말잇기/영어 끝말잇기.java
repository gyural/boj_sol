import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> wordSet = new HashSet<String>();
        
        char beforeChar = words[0].charAt(0);
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (word.charAt(0) != beforeChar || wordSet.contains(word)){
                answer[0] = i % n +1;
                answer[1] = i / n +1;
                break;
            }
            beforeChar = word.charAt(word.length()-1);
            wordSet.add(word);
        }
        
        return answer;
    }
}