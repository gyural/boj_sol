class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        DFS(numbers, 1, target, numbers[0], numbers.length);
        DFS(numbers, 1, target, -numbers[0], numbers.length);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int idx, int goal, int value, int size) {
        if (idx == size){
            if (value == goal){
                answer +=1;
            }
            return;
        }
        
        DFS(numbers, idx+1, goal, value+numbers[idx], size);
        DFS(numbers, idx+1, goal, value-numbers[idx], size);
        
    }
}