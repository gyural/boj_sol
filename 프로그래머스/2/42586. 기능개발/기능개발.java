import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList(); 
        int size = progresses.length;
        int toDeployIdx = 0;
        
        while (toDeployIdx < size) {
            // 작업 시작
            for (int i =0; i<size; i++) progresses[i] = Math.min(100, speeds[i]+progresses[i]);
            
            
            if (progresses[toDeployIdx] >= 100){
                // 배포작업
                int count = 0;
                
                for (int i = toDeployIdx; i <size; i++){
                    if (progresses[i] >= 100){
                        count++;
                    } else{
                        break;
                    }
                }
                
                list.add(count);
                toDeployIdx += count;
            }
            
        }
        
        System.out.println(list.toString());
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
}