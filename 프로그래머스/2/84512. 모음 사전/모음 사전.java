import java.util.*;

class Solution {
    static ArrayList<String> dict = new ArrayList<>();
    static String[] els = new String[]{"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        
        for (String el: els){
            DFS(el);
        }
        dict.sort((a,b) -> a.compareTo(b));
        
        for (int i =0; i< dict.size(); i++){
            if (dict.get(i).equals(word)){
                return i+1;
            }
        }
        
        return answer;
    }
    
    private void DFS(String curString){
        if (curString.length() >5) {
            return;
        } else {
            if (dict.contains(curString) == false){
                dict.add(curString);
            }
        }
        
        for (String el :els){
            DFS(curString+el);
        }
    }
}