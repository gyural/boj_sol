import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] candiChar = new char[]{'S', 'D', 'T'};
        
        int[] answerArr = new int[3];
        char[] bonusArr = new char[3];
        char[] charArr = new char[3];
        
        int beforeChar = -1;
        int cnt=0;
        int cnt1=0;
        for (int i=0; i<dartResult.length(); i++){
            for (int j=0; j<3; j++){
                if (dartResult.charAt(i) == candiChar[j]){
                    charArr[cnt] = candiChar[j];
                    String charBetween = dartResult.substring(beforeChar+1, i);
                    
                    if (charBetween.charAt(0) == '*' || charBetween.charAt(0) == '#'){
                        answerArr[cnt] =  Integer.valueOf(charBetween.substring(1));
                        
                    } else{
                        answerArr[cnt] = Integer.valueOf(charBetween);
                    }
                    cnt++;
                    
                    
                    // 보너스 확인
                    if (i+1 < dartResult.length()){
                        if (dartResult.charAt(i+1) == '*' || dartResult.charAt(i+1) == '#'){
                            bonusArr[cnt1] = dartResult.charAt(i+1);
                        } 
                        cnt1++;
                    }
                    
                    beforeChar = i;
                }
            }
        }
        
        
        
        
        for (int i=0; i<3; i++){
            // 1. S D T 계산
            switch (charArr[i]){
                case 'S':
                    answerArr[i] = (int)Math.pow(answerArr[i], 1);
                    break;
                case 'D':
                    answerArr[i] = (int)Math.pow(answerArr[i], 2);
                    break;
                case 'T':
                    answerArr[i] = (int)Math.pow(answerArr[i], 3);
                    break;
            }
            
            // 2. Bonus계산
            if (bonusArr[i] == '*'){
                // 1번째인 경우
                if (i==0){
                    answerArr[0] = answerArr[0] * 2; 
                } else{
                    answerArr[i-1] = answerArr[i-1] * 2;
                    answerArr[i] = answerArr[i] * 2;
                }
            } else if (bonusArr[i] == '#'){
                answerArr[i] = answerArr[i] * -1; 
            }
        }
        
        System.out.println(Arrays.toString(answerArr));
        System.out.println(Arrays.toString(bonusArr));
        System.out.println(Arrays.toString(charArr));
        
        for (int i=0; i<3; i++) {answer += answerArr[i];}
        
        return answer;
    }
}