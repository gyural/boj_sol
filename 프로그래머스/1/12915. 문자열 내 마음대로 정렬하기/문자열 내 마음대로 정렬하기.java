import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        List<String> stringList = new ArrayList();
        
        Arrays.sort(strings);
        
        for (String s: strings) stringList.add(s);
        
        stringList.sort((a,b) -> a.charAt(n) - b.charAt(n));
        
        for (int i =0; i< stringList.size(); i++) answer[i] = stringList.get(i);
        
        return answer;
    }
}


// 1. List의 string일때 정렬 역정렬이 가능해야함 사전순...
// 2. 일반 array일때 역사전순 정렬이 가능해야함