import java.util.*;
// 3시 6분 시작

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int size = enroll.length;
        int sellerSize = seller.length;
        Map<String, String> childIdx2Parent = new HashMap<>();
        Map<String, Integer> seller2Result = new HashMap<>();
        
        for (int i=0; i<size; i++){
            String parent =  referral[i];
            String child = enroll[i];
            childIdx2Parent.put(child, parent);
            seller2Result.put(child, 0);
            
        }
        
        for (int i =0; i< sellerSize; i++){
            String sellerName = seller[i];
            
            int cost = amount[i] * 100;
            
            
            while(true){
                if (sellerName.equals("-")){
                    break;
                }
                if (cost == 0){
                    break;
                }
                
                int leftCost = cost / 10;
                int finalCost = cost - leftCost;
                cost = leftCost;
                
                seller2Result.put(sellerName, seller2Result.get(sellerName) + finalCost);
                
                // 다음 seller지정
                sellerName = childIdx2Parent.get(sellerName);
                
                
            }
            
        }
        
        
        int[] answer = new int[size];
        for (int i=0; i<size; i++){
            answer[i] = seller2Result.get(enroll[i]);
        }
        return answer;
    }
}