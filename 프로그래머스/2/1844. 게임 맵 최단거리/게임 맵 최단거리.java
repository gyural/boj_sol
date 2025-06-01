import java.util.*;

class Solution {
    
    int[] dy = new int[]{-1,1,0,0}; 
    int[] dx = new int[]{0,0,-1,1}; 
    
    public int solution(int[][] maps) {
        int answer = -1;
        int ySize = maps.length;
        int xSize = maps[0].length;
        
        Deque<int[]> Q = new ArrayDeque<int[]>();
        
        Q.add(new int[]{0,0,0});
        
        boolean[][] visit = new boolean[ySize][xSize]; 
        visit[0][0] = true;
        
        
        
        
        while(Q.peek() != null){
            int[] curArr = Q.pollFirst();
            int curY = curArr[0];
            int curX = curArr[1];
            int cost = curArr[2];
            
            for (int i=0; i<4; i++){
                int nxtY = curY + dy[i];
                int nxtX = curX + dx[i];
                if ((nxtY >=0 && nxtY < ySize) && (nxtX >=0 && nxtX < xSize) && maps[nxtY][nxtX] != 0){
                    // 종료 조건
                    if (nxtY == ySize-1 && nxtX == xSize-1){
                        return cost+2;
                    }
                    
                    if (visit[nxtY][nxtX] == false ){
                        Q.add(new int[]{nxtY, nxtX, cost+1});
                        visit[nxtY][nxtX] = true;
                    }
                }
            }
            
        }
            
        
        return answer;
    }
}