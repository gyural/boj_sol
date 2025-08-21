import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> Id2Nickname = new HashMap<>();
        
        // 1. 최종 nickName으로 저장하기
        for (String log :record){
            
            String[] split = log.split(" ");
            String cmd = split[0]; 
            
            
            if(!cmd.equals("Leave")){
                String id = split[1]; 
                String nickname = split[2];
                Id2Nickname.put(id, nickname);
            }
        }
        
        List<String> answerList = new ArrayList<>();
        
        for (String log :record) {
            String[] split = log.split(" ");
            String cmd = split[0]; 
            
            if (cmd.equals("Enter")){
                String id = split[1];
                String el = Id2Nickname.get(id)+"님이 들어왔습니다.";
                answerList.add(el);
            } else if (cmd.equals("Leave")){
                String id = split[1];
                String el = Id2Nickname.get(id)+"님이 나갔습니다.";
                answerList.add(el);
            }
        }

        
        // 최종 응답 변환
        String[] answer = new String[answerList.size()];
        for (int i=0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        
        return answer;
    }
    
}