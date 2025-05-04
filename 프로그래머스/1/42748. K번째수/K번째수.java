import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int count = 0;
        for (int[] cmd: commands){
            int start = cmd[0]-1;
            int end = cmd[1]-1;
            int k = cmd[2]-1;
            
            int[] subArr = new int[end-start+1];
            for (int i=0; i<end-start+1; i++) subArr[i] = array[i+start];
            
            Arrays.sort(subArr);
            answer[count] = subArr[k];
            count++;
            
        }
        return answer;
    }
}