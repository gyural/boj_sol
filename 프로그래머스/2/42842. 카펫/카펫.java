import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        
        for (int r=2; r <= 2500; r++){
            for (int c=2; c<=2500; c++){
                if(c * r != brown + yellow) continue;
                
                int needBrown = 2*c + 2*r - 4;
                if (needBrown != brown) continue;
                int needYellow = c*r - needBrown;
                if (needYellow != yellow) continue;
                
                answer[0] = r;
                answer[1] = c;
                break;
            }
        }
        
        List<Integer> list = new ArrayList();
        list.add(answer[0]);
        list.add(answer[1]);
        list.sort(Collections.reverseOrder());
        
        answer[0] = list.get(0);
        answer[1] = list.get(1);
        
        return answer;
    }
}