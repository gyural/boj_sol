class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        // 4 -> 2 -> 1 -> 1
        // 7 -> 4 -> 2 -> 1
            
        // 다음라운드에 주어지게 되는 번호는 앞에 팀의 수 / 2 + 1임
            
        // 앞의 팀의 수 계산 법 짝수-2 / 2 홀수-1 / 2
        
        while (a!=b){
            a = a%2 == 0? (a-2) / 2 + 1 : (a-1) / 2 + 1;
            b = b%2 == 0? (b-2) / 2 + 1 : (b-1) / 2 + 1;
            answer +=1;
        }

        return answer;
    }
}