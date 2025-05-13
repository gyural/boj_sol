import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int v: nums) set.add(v);
        
        answer = Math.min(nums.length/2, set.size());
        return answer;
    }
}