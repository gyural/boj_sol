import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String tmp = "";
        for (int i=0; i<s.length(); i++) tmp+= s.charAt(i);
        // List<String> binaryList = new ArrayList();
        
        
        while (!tmp.equals("1")){
            int zeroNum =0;
            int oneNum = 0;
            
            for (int i=0; i<tmp.length(); i++){
                char targetChar = tmp.charAt(i);
                
                if (targetChar == '0'){
                    zeroNum +=1;
                }else{
                    oneNum +=1;
                }
            }
            
            int nextValue = oneNum;
            answer[1] += zeroNum;
            answer[0] += 1;
            tmp = getBinaryString(oneNum);
        }
        
        
        return answer;
    }
    private String getBinaryString(int value){
        int size = 0;
        for (int i=0; i<100; i++){
            if (value < Math.pow(2, i)){
                size = i;
                break;
            }
        }
        String result = "";
        for (int i=size-1; i>=0; i--){
            int targetNum = (int)Math.pow(2, i);
            
            if (value >= targetNum){
                value -= targetNum;
                result += "1";
            }else{
                result += "0";
            }
            
        }
        
        return result;
        
    }
}