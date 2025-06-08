import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String, Integer> set1 = new HashMap<String, Integer>();
        Map<String, Integer> set2 = new HashMap<String, Integer>();
        
        Map<String, Integer> subSet = new HashMap<String, Integer>();
        Map<String, Integer> sumSet = new HashMap<String, Integer>();
        
        for (int i=0; i<str1.length()-1; i++){
            char first = Character.toUpperCase(str1.charAt(i));
            char second = Character.toUpperCase(str1.charAt(i+1));
            
            if ((first >= 'A' && first <= 'Z') && (second >= 'A' && second <= 'Z')){
                String subStr = "" + first + second;
                
                if (set1.get(subStr) == null){
                    set1.put(subStr, 1);
                } else{
                    set1.put(subStr, set1.get(subStr)+1);
                }
            }
            
        }
        
        for (int i=0; i<str2.length()-1; i++){
            char first = Character.toUpperCase(str2.charAt(i));
            char second = Character.toUpperCase(str2.charAt(i+1));
            
            if ((first >= 'A' && first <= 'Z') && (second >= 'A' && second <= 'Z')){
                String subStr = "" + first + second;
                if (set2.get(subStr) == null){
                    set2.put(subStr, 1);
                } else{
                    set2.put(subStr, set2.get(subStr)+1);
                }
            }
            
        }
        
        set1.forEach((k,v) -> {
            if (set2.get(k) == null){
                sumSet.put(k, set1.get(k));
            } else{
                subSet.put(k,  Math.min(set1.get(k), set2.get(k)));
                sumSet.put(k,  Math.max(set1.get(k), set2.get(k)));
            }
        });
        set2.forEach((k,v) ->{
            if (sumSet.get(k) == null){
                sumSet.put(k,v);
            }
        });
        
        double subSetSize = 0;
        double sumSetSize = 0;
        
        for (int v : subSet.values()){
            subSetSize += v;
        }
        
        for (int v : sumSet.values()){
            sumSetSize += v;
        }
        
        
        System.out.println(subSetSize + " " + sumSetSize);
        
        if (sumSetSize == 0) return 65536;
        
        return (int)(subSetSize/sumSetSize*65536);
    }
}