import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int userSize = stages.length;
        
        Arrays.sort(stages);
        
        double[] clearRate = new double[N+2];
        
        // 전체 클리어율을 0으로 초기화
        for (int i=0; i<=N; i++){
            clearRate[i] = 0;
        }
        
        for (int i=0; i<userSize; i++){
            if (i == 0){
                // K 스테이지의 머문 사용자 Count
                int curKUser = 1;
                for (int j=i+1; j<userSize; j++){
                    if (stages[j] == stages[i]) curKUser++;
                }
                // K를 경험한 모든 사용자
                int KTotalUser = userSize - i;
                // 최종 Clear율 계산    
                clearRate[stages[i]] = (double) curKUser / KTotalUser;
            }
            // 새로운 스테이지에 머문 유저 등장
            else if (stages[i] != stages[i-1]){
                // K 스테이지의 머문 사용자 Count
                int curKUser = 1;
                for (int j=i+1; j<userSize; j++){
                    if (stages[j] == stages[i]) curKUser++;
                }
                // K를 경험한 모든 사용자
                int KTotalUser = userSize - i;
                // 최종 Clear율 계산    
                clearRate[stages[i]] = (double) curKUser / KTotalUser;
                
            }
        }
        
        List<List<Double>> idxClearRateList = new ArrayList<>();
        for (int i=1; i<=N; i++){
            ArrayList<Double> el = new ArrayList<>();
            el.add(new Double(i));
            el.add(new Double(clearRate[i]));
            idxClearRateList.add(el);
        }
        
        idxClearRateList.sort((a,b)-> Double.compare(b.get(1), a.get(1)));
        
        for (int i=0; i<N; i++){
            answer[i] = (int)(double) idxClearRateList.get(i).get(0);
        }
        
        return answer;
    }
}