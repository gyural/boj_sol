import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(long n) {
        
        // 1. 자리수 구하기
        int n3Size = 1; // 3진법 변환시 자리수임....
        while (true){
            if (n >= pow(3, n3Size-1) * 3){
                n3Size++;
            } else break;
        }
        
        // 2. 3진법 String으로 만들기
        List<Long> nBy3Arr = new ArrayList();
        
        for (int i =0; i<n3Size; i++){
            
            long targetSquareNum = pow(3, n3Size-1-i);
            
            long divNum = (int) n / targetSquareNum;
            
            nBy3Arr.add(divNum);
            
            n = n % targetSquareNum;
            
        }
        
        // System.out.println(nBy3Arr.toString());
        
        int answer = 0;
        
        for (int i = 0; i < nBy3Arr.size(); i++) answer += pow(3,i) * nBy3Arr.get(i); 
        
        return answer;
    }
    
    private long pow(int a,int b){
        long res = 1;
        
        for (int i=0; i<b; i++) res *= a;
        
        return res;
    }
}