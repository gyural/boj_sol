import java.util.*;

class Solution {
    static int count =0;
    public int solution(int[] nums) {
        // 1. 3000까지 소수 판별
        boolean[] isPrime = new boolean[3001];
        for (int i=2; i<=3000;i++){
            isPrime[i] = true;
        }
        
        for (int i=2; i<=3000; i++){
            for (int j=i+i; j<=3000; j+=i){
                isPrime[j] = false;
            }
        }
        int size = nums.length;
        // 2. DFS로 가능한 경우 탐색
        for (int i=0; i<= nums.length-1-1; i++){
            DFS(i, nums, 1, nums[i], isPrime, size);
        }
        
        return count;
    }
    public void DFS(int idx, int[] nums, int depth, int sum, boolean[] isPrime, int size){
        // 종료 조건
        if (depth == 3){
            if (isPrime[sum] == true){
                count +=1;
            }
            return;
        }
        for (int i=idx+1; i<size; i++){
            DFS(i, nums, depth+1, sum+nums[i], isPrime, size);
        }
    }
}