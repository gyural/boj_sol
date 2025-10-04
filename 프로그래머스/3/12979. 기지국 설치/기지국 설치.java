class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int size = stations.length;
        
        // 1 현재 station을 기준으로 이전 공백길이를 리턴
        for(int i=1; i < size; i++){
            int start = stations[i-1] + w + 1;
            if (start >= stations[i] - w){
                continue;
            }
            
            int end = stations[i] - w - 1;
            
            int noSignalLength = end - start + 1;
            
            // 필요한 station 누적하기
            answer += getMinimumStations(noSignalLength, w); 
        }
        
        // 3. 처음 부분 공백
        int noSignalStartLength = stations[0] - w - 1;
        answer += getMinimumStations(noSignalStartLength, w); 

        
        // 4. 마지막 구분 공백 처리
        int noSignalEndLength = n - (stations[size-1] + w + 1) + 1;
        answer += getMinimumStations(noSignalEndLength, w);

        return answer;
    }
    
    private int getMinimumStations(int length, int w){
        if (length <= 0){
            return 0;
        }
        
        int realW = w * 2 + 1;
        if (length % realW == 0){
            return length / realW;
        }
        
        return length / realW + 1;
    }
}