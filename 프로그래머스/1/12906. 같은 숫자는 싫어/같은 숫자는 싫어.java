import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> arrList = new ArrayList();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.addLast(arr[0]-1);
        
        for (int v: arr){
            if (v != stack.getLast()) {
                stack.removeLast();
                stack.addLast(v);
                arrList.add(v);
            }
        }
        
        return arrList.stream().mapToInt(Integer::intValue).toArray();
    }
}