import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int curCorrect = 0;
        int zeroCount = 0;
        List<Integer> winList = new ArrayList<>();
        
        for (int n: win_nums) winList.add(n);
        
        // 1. 일치하는게 현재 몇개인지
        for (int n: lottos) {
            if (n == 0){
                zeroCount++;
            }
            else if (n != 0 && winList.contains(n)){
                curCorrect++;
            }
        }
        
        // 2. 0의 개수로 min max 구하기
        int maxCorrect = curCorrect + zeroCount;
        int minCorrect = curCorrect;
        
        answer[0] = maxCorrect >= 2 ? 7-maxCorrect : 6;
        answer[1] = minCorrect >= 2 ? 7-minCorrect : 6;
        return answer;
    }
}