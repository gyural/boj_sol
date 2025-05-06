import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> missScore = new HashMap();
        // HashMap에 점수 저장
        for (int i=0; i<name.length; i++) missScore.put(name[i], yearning[i]);
        
        for (int i=0; i<photo.length; i++){
            for (String n: photo[i]) answer[i] += missScore.get(n) != null ? missScore.get(n) : 0;
        }
        return answer;
    }
}