/*
방법1. ArrayList add 후 정렬
방법2. 힙 자료구조 사용

*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> arrList = new ArrayList();
        
        for (int v: arr){
            
            if (v % divisor == 0){
                arrList.add(v);
            }
            
        }
        arrList.sort((a,b) -> a - b);
        
        int size = arrList.size();
        if (size == 0){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++){
            answer[i] = arrList.get(i);
        }
        
        return answer;
    }
}