class Solution {
    public int solution(int n) {
        int answer = n;
        int oneNum = toBinaryStringCountOne(n);
        
        while (true){
            answer +=1;
            if (toBinaryStringCountOne(answer) == oneNum) break;
        }
        
        return answer;
    }
    
    private int toBinaryStringCountOne(int value){
        int size =0;
        for (int i=0; i<30; i++){
            if (value < Math.pow(2,i)){
                size = i;
                break;
            }
        }
        
        int answer = 0;
        for (int i=size-1; i>=0; i--){
            int targetNum = (int)Math.pow(2,i);
            if (value >= Math.pow(2,i)){
                value -= targetNum;
                answer += 1;
            } else{
            }
        }
        
        return answer;
        
    }
}