class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] countArr = new int[1000001];
        
        for (int i=1; i<=1000000; i++){
            for (int j=i; j <= 1000000; j+=i){
                countArr[j] +=1;
            }
        }
        
        for (int i=2; i<=n; i++){
            if (countArr[i] == 2){
                answer +=1;
            }
        }
        return answer;
    }
}