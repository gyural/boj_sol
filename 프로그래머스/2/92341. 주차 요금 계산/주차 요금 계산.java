import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int elTime = fees[0];
        int elFee = fees[1];
        int timeSlot = fees[2];
        int feePerTimeSlot = fees[3];
        
        Map<String, Integer> car2SpendTime = new HashMap<>();
        Map<String, Integer> car2InTime = new HashMap<>();
        
        for (String elString : records){
            String timeString = elString.split(" ")[0];
            String carNumString = elString.split(" ")[1];
            String inoutString = elString.split(" ")[2];
            
            int curTime = Integer.valueOf(timeString.split(":")[0]) * 60 + Integer.valueOf(timeString.split(":")[1]);
            if (inoutString.equals("IN")) {
                car2InTime.put(carNumString, curTime);
            } else if (inoutString.equals("OUT")){
                int diffTime = curTime - car2InTime.get(carNumString);
                
                if (car2SpendTime.get(carNumString) == null){
                    car2SpendTime.put(carNumString, diffTime);
                } else{
                    car2SpendTime.put(carNumString, diffTime + car2SpendTime.get(carNumString));
                }
                car2InTime.remove(carNumString);
            }
        }
        
        // 아직 입차중인 차 23시 59분 출차 처리
        for (String remainCarNum : car2InTime.keySet()){
            int diffTime = 23*60+59 - car2InTime.get(remainCarNum);
            if (car2SpendTime.get(remainCarNum) == null){
                    car2SpendTime.put(remainCarNum, diffTime);
                } else{
                    car2SpendTime.put(remainCarNum, diffTime + car2SpendTime.get(remainCarNum));
                }
        }
        
        List<String> carNumList = new ArrayList<>();
        
        for (String carNum : car2SpendTime.keySet()){
            carNumList.add(carNum);
        }
        
        carNumList.sort((a,b) -> Integer.valueOf(a)-Integer.valueOf(b));
        
        int[] answer = new int[carNumList.size()];
        
        for (int i=0; i<carNumList.size(); i++){
            int spendTime = car2SpendTime.get(carNumList.get(i));
            
            if (spendTime <= elTime){
                answer[i] = elFee;
            } else{
                double timesOver = (double)(spendTime-elTime)/timeSlot;
                
                // 소수점이 있을 때
                if (timesOver > (double)(int)timesOver){
                    answer[i] = elFee + ((int)timesOver + 1) * feePerTimeSlot;
                } else{
                    answer[i] = elFee + ((int)timesOver) * feePerTimeSlot;
                    
                }
                    
            }
        }
        
        
        return answer;
    }
}