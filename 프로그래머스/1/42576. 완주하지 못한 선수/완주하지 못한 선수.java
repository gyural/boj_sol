import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int pt1 = 0;
        int pt2 = 0;
        int pSize = participant.length;
        
        for (int i=0; i<pSize-1; i++){
            if (!participant[pt1].equals(completion[pt2])){
                return participant[pt1];
            }
            pt1++;
            pt2++;
        }
        
        
        return participant[pSize-1];
    }
}