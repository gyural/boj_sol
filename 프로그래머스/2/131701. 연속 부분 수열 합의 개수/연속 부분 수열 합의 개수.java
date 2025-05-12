import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> HashSet = new HashSet<Integer>();
        
        int size = elements.length;
        int[] elementDouble = new int[elements.length * 2];
        
        for (int i=size; i< size *2; i++) elementDouble[i] = elements[i-size];
        for (int i=0; i< size; i++) elementDouble[i] = elements[i];
        
        for (int i=0; i< size; i++){
            int tmp =0;
            for (int j=i; j < i+size; j++){
                tmp += elementDouble[j];
                HashSet.add(tmp);
            }
        }
        // System.out.println(HashSet.toString());
        answer = HashSet.size();
        return answer;
        
        
        
    }
}