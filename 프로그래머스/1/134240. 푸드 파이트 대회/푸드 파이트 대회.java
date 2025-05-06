class Solution {
    public String solution(int[] food) {
        String answer = "";
        String left = "";
        String right = "";
        for (int i =0; i< food.length; i++){
            for (int j=0; j < food[i] / 2; j++) left += (char)('0' + i);
        }
        
        for (int i =left.length()-1; i >=0 ; i--) right += left.charAt(i);
        
        
        for (int i = 0; i < left.length(); i++) answer += left.charAt(i);
        answer += '0';
        for (int i = 0; i < right.length(); i++) answer += right.charAt(i);
        
        
        
        return answer;
    }
}