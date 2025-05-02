class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[arr.length-1];
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            min = Math.min(arr[i], min);
        }
        
        int count = 0;
        for (int v: arr){
            if (v != min) answer[count++] = v;
        }
        
        
        return answer;
    }
}