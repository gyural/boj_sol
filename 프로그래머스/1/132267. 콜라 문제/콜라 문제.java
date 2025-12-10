class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int curBottleNum = n;
        int collectNum = a;
        int bonusNum = b;
        
        while(curBottleNum >= collectNum) {
            
            int divNum = curBottleNum / collectNum;
            int modNum = curBottleNum % collectNum;
            int newBottle = divNum * bonusNum;
            
            
            answer+= newBottle;
            
            curBottleNum = newBottle + modNum;
        }
        
        return answer;
    }
}