import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Set<Integer> visit = new HashSet<>();
        Deque<QEl> Q = new ArrayDeque<>();
        
        Q.addFirst(new QEl(x, 0));
        visit.add(x);
        
        while(Q.size()  > 0){
            QEl curEl = Q.pollLast();
            // 0. 종료 조건
            if (curEl.num == y){
                return curEl.time;
            }
            
            // 1. n을 더함
            int nxtValue1 = curEl.num + n;
            if (nxtValue1 <= y && !visit.contains(nxtValue1)){
                Q.addFirst(new QEl(nxtValue1, curEl.time+1));
                visit.add(nxtValue1);
            }
            
            // 2. 2를 곱함
            int nxtValue2 = curEl.num * 2;
            if (nxtValue2 <= y && !visit.contains(nxtValue2)){
                Q.addFirst(new QEl(nxtValue2, curEl.time+1));
                visit.add(nxtValue2);
            }
            
            // 3. 3을 곱함
            int nxtValue3 = curEl.num * 3;
            if (nxtValue3 <= y && !visit.contains(nxtValue3)){
                Q.addFirst(new QEl(nxtValue3, curEl.time+1));
                visit.add(nxtValue3);
            }
        }
        
        return -1;
    }
    
    private class QEl{
        public int num; // 숫자
        public int time; // 횟수
        
        public QEl(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
    
    
}