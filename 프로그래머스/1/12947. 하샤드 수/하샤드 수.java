import java.util.Arrays;

class Solution {
    public boolean solution(int x) {
        
        int sum = 0;
        for (int v: Arrays.stream((x+"").split("")).mapToInt(Integer::parseInt).toArray()){
            sum += v;
        }
             
        
        return x % sum == 0? true : false;
    }
}