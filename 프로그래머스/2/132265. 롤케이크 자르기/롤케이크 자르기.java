import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        
        int[] sumArrBeginFront = new int[topping.length];
        int[] sumArrBeginBack = new int[topping.length];
        
        // 1. sumArrBeginFront 누적하기
        Set<Integer> numSet = new HashSet<Integer>();
        sumArrBeginFront[0] = 1;
        numSet.add(topping[0]);
        
        for (int i =1; i<topping.length; i++){
            if (numSet.contains(topping[i])){
                sumArrBeginFront[i] = sumArrBeginFront[i-1];
            } else{
                numSet.add(topping[i]);
                sumArrBeginFront[i] = sumArrBeginFront[i-1]+1;
            }
        }
        
        // 2. sumArrBeginBack 누적하기
        numSet = new HashSet<Integer>();
        sumArrBeginBack[topping.length-1] = 1;
        numSet.add(topping[topping.length-1]);
        
        for (int i=topping.length-2; i >=0; i--){
            if (numSet.contains(topping[i])){
                sumArrBeginBack[i] = sumArrBeginBack[i+1];
            } else{
                numSet.add(topping[i]);
                sumArrBeginBack[i] = sumArrBeginBack[i+1]+1;
            }
        }

        
        for (int i=0; i<=topping.length-2; i++){
            
            if (sumArrBeginFront[i] == sumArrBeginBack[i+1]){
                answer++;
            }
        }
        return answer;
    }
}