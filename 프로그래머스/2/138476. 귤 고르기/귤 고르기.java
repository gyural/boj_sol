import java.util.PriorityQueue;
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Integer> countArr = new ArrayList();
        
        // 누적 배열 만들기
        Arrays.sort(tangerine);
        int cnt = 1;
        
        for (int i=1; i<tangerine.length; i++){
            if (tangerine[i] == tangerine[i-1]) {
                cnt++;
            } else{
                countArr.add(cnt);
                cnt = 1;
            }
        }
        countArr.add(cnt);
        
        int sum = 0;
        for (int v: countArr) sum += v;
        // 빼야할 수 
        int exitNum = sum - k;
        
        countArr.sort((a,b) -> a-b);
        List<Integer> countSumArr = new ArrayList();
        countSumArr.add(countArr.get(0));
        for (int i=1; i<countArr.size(); i++){
            countSumArr.add(countSumArr.get(i-1)+countArr.get(i));
        }
        
    
        int count = 0;
        for (int i=1; i<= exitNum; i++){
            if (countSumArr.get(count) <= i){
                count +=1;
                if (count >= countArr.size()){
                    return 0;
                }
            }
        }
        return countArr.size()-count;
    }
}