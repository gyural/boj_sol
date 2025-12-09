import java.util.*;

class Solution {
    private static final int lastAlpha = (int)'z';
    private static final int firstAlpha = (int)'a';
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        
        Set<Character> skipSet = new HashSet<>();
        for (int i=0; i<skip.length(); i++){
            skipSet.add(skip.charAt(i));
        }
        
        
        for (int i=0; i<size; i++) {
            sb.append(
                shift(s.charAt(i), index, skipSet)
                );

        }
        
        
        return sb.toString();
    }
    
    
    private char shift(char target, int v, Set<Character> skip) {
        int count = 0;
        char curChar = target;

        
        while(count < v){
            curChar = nxtChar(curChar);
            if (skip.contains(curChar)){
                continue;
            }
            count++;
        }
        
        return curChar;
    }
    
    private char nxtChar(char c) {
        int charByInt = (int) c;
        int nxtCharByInt = charByInt + 1;
        
        if (nxtCharByInt > lastAlpha){
            return (char)(nxtCharByInt - lastAlpha + firstAlpha-1);
        }
        
        return (char)nxtCharByInt;
            
            
    }
}