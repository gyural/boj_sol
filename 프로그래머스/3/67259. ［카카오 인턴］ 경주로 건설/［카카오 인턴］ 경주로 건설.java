// 11시 31분 시작

import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 25 * 25 * 600;
        int DIRECT_COST = 100;
        int CORNER_COST = 500;
        
        int size = board.length;
        
        int UP = 0;
        int DOWN = 1;
        int LEFT = 2;
        int RIGHT = 3;
        
        
        int[] dy = {-1, 1, 0, 0};        
        int[] dx = {0, 0, -1, 1};
        
        Deque<QEl> Q = new ArrayDeque<>();
        int[][][] visit = new int[size][size][4];
        
        // 처음 오른쪽 출발
        if (board[0][1] == 0){
            QEl rightEl = new QEl(0,0,RIGHT, 0);
            visit[0][0][RIGHT] = 0;
            Q.addLast(rightEl);
        }
        
        // 처음 아래쪽 출발
        if (board[1][0] == 0){
            QEl downEl = new QEl(0,0,DOWN, 0);
            visit[0][0][DOWN] = 0;
            Q.addLast(downEl);
        }
        
        while(Q.size() > 0){
            QEl curEl = Q.pollFirst();
            // 1. 도착한 경우
            if (curEl.y == size-1 && curEl.x == size-1){
                answer = Math.min(curEl.cost, answer);
                continue;
            }
            
            
            for (int i=0; i<4; i++){
                int nxtY = dy[i] + curEl.y;
                int nxtX = dx[i] + curEl.x;
                
                // 경계를 넘는지 검사
                if (isOut(nxtY, nxtX, size)){
                    continue;
                }
                
                // 벽인지 검사
                if (board[nxtY][nxtX] == 1){
                    continue;
                }
                
                int nxtCost =  curEl.direction == i ? curEl.cost +100 : curEl.cost +600;
                if (visit[nxtY][nxtX][i] != 0 && visit[nxtY][nxtX][i] < nxtCost){
                    continue;
                }
                QEl newEl = new QEl(nxtY,nxtX, i, nxtCost);
                
                
                visit[nxtY][nxtX][i] = nxtCost;
                Q.addLast(newEl);
            }
            
        }
        
        return answer;
    }
    
    public boolean isOut(int y, int x, int size){
        if (y < 0 || y >= size){
            return true;
        }
        
        if (x < 0 || x >= size){
            return true;
        }
        
        return false;
    }
    
    public class QEl {
        int y;
        int x;
        int direction;
        int cost;
        
        public QEl(int y, int x, int direction, int cost) {
            this.y = y; 
            this.x = x; 
            this.direction = direction;
            this.cost = cost;
        }
        
        @Override
        public String toString() {
            return "y=" + y + "x=" + x + "D=" +direction + "cost=" + cost;
        }
    }
        
}