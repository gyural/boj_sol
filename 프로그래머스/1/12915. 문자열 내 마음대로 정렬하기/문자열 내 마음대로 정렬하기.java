import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int size = strings.length;
        String[] answer = new String[size];
        
        List<String> arr = new ArrayList<>();
        for (String s : strings) {
            arr.add(s);
        }
        
        arr.sort((a,b) -> a.compareTo(b));
        arr.sort((a,b) -> {
            return a.charAt(n) - b.charAt(n);
        });
        
        
        for (int i=0; i<size; i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}