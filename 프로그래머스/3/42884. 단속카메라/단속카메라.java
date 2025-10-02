import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        // 1. 전처리 : 작은거 -> 큰거 순으로 route 요소 만들기
        List<List<Integer>> routesList = new ArrayList<>();
        for(int[] r : routes) {
            List<Integer> el =  new ArrayList<>();
            el.add(Math.min(r[0], r[1]));
            el.add(Math.max(r[0], r[1]));
            
            routesList.add(el);
        }
        
        // 2. 정렬
        // 출구 지점 기준 정렬
        routesList.sort((a,b) -> Integer.compare(a.get(1), b.get(1)));
        
        
        int cam = routesList.get(0).get(1);
            
        for (List<Integer> r : routesList){
            int curStart = r.get(0);
            int curEnd = r.get(1);
            
            if (curStart > cam ){
                answer += 1;
                cam = curEnd;
                    
            }
            
        }
        
        
        return answer;
    }
    
    private boolean isContain(int startCam, int endCam, int curStart, int curEnd){

        boolean isStartContain = (curStart >= startCam && curStart <= endCam);
        boolean isEndContain = (curEnd >= startCam && curEnd <= endCam);
        if (isStartContain ||  isEndContain) {
            return true;
        } else {
            return false;
        }
    }
    
}
        
