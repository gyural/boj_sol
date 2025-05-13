import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[] per1 = {1, 2, 3, 4, 5};
        int[] per2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] per3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
         
        for (int i =0; i<answers.length; i++){
            if (per1[i%per1.length] == answers[i]) score[0]++;
            if (per2[i%per2.length] == answers[i]) score[1]++;
            if (per3[i%per3.length] == answers[i]) score[2]++;
        }
        
        System.out.println(Arrays.toString(score));
        
        int maxScore = -1;
        for (int v: score) maxScore = Math.max(v, maxScore);
        
        List<Integer> list = new ArrayList();
        for (int i =0; i<3; i++) 
            if(score[i] == maxScore){
                list.add(i);
            } 
        int[] answer = new int[list.size()];
        for (int i =0; i<answer.length; i++) answer[i] = list.get(i)+1;
        
        return answer;
    }
}