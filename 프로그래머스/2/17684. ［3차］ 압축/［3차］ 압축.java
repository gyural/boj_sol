import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int size = 1;
        HashMap<String, Integer> dict = new HashMap<>();
        
        for (int i='A'-'A'; i<'Z'-'A'+1; i++){
            dict.put(""+ (char) ('A'+i), size++);
        }
        
        int k=0;
        while (k<msg.length()){
            String w = ""+msg.charAt(k);
            int index = dict.get(w);
            if (k == msg.length()-1) {
                answerList.add(index);
                break;
            }            
            
            int j;
            for (j=k+1; j< msg.length(); j++){
                String wc = msg.substring(k,j+1);
                if (dict.keySet().contains(wc)){
                    index = dict.get(wc);
                    if (j== msg.length()-1) k = j+1;
                } else{
                    dict.put(wc, size++);
                    k = j;
                    break;
                }
            }
            
            answerList.add(index);
            
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) answer[i] = answerList.get(i);
        
        return answer;
    }
}